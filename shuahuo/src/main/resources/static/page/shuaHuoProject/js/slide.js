
//生成slide里面元素
var slide = document.getElementsByClassName("slide");
var drag = document.createElement('div');
var bg = document.createElement('div');
var text = document.createElement('div');
var btn = document.createElement('div');
drag.className = "drag";
bg.className = "bg";
text.className = "text";
text.onselectstart = "return false;";
text.innerText = "请拖动滑块解锁";
btn.className = "btn";

drag.appendChild(bg);
drag.appendChild(text);
drag.appendChild(btn);
slide[0].appendChild(drag);

//生成slide外面元素
var canbaswapper0 = document.createElement('div');
var canvas0 = document.createElement('canvas');
var block0 = document.createElement('canvas');

canbaswapper0.className = "canvaswapper";
canvas0.id = "canvas";
canvas0.width = "300";
canvas0.height = "100"

block0.id = "block";
block0.width = "300";
block0.height = "100"

canbaswapper0.appendChild(canvas0);
canbaswapper0.appendChild(block0);
slide[0].parentNode.insertBefore(canbaswapper0, slide.nextSiblings);

//选择画布
var canvas = document.getElementById('canvas');
var block = document.getElementById('block');
var canvas_ctx = canvas.getContext('2d');
var block_ctx = block.getContext('2d');
var ver = document.createElement('img');
var gap = document.createElement('img');
ver.onload = function () {
    canvas_ctx.drawImage(ver, 0, 0, 300, 100);
};
gap.onload = function () {
    block_ctx.drawImage(gap, 0, 0, 300, 100);
};
ver.src = '../../resources/img/ver.png';
gap.src = '../../resources/img/gap.png';

//判断验证是否成功
var slideResult = false;

var slide =  function () {
    //一、定义一个获取DOM元素的方法
    var $ = function (selector) {
        return document.querySelector(selector);
    },
        box11 = $(".drag"),//容器
        bg = $(".bg"),//背景
        text = $(".text"),//文字
        btn11 = $(".btn"),//滑块
        canvaswapper = $(".canvaswapper"),
        success = false,//是否通过验证的标志
        distance = 256;//滑动成功的宽度（距离）

    //二、给滑块注册鼠标按下事件
    btn.onmousedown = function (e) {

        //1.鼠标按下之前必须清除掉后面设置的过渡属性
        btn.style.transition = "";
        bg.style.transition = "";

        //说明：clientX 事件属性会返回当事件被触发时，鼠标指针向对于浏览器页面(或客户区)的水平坐标。

        //2.当滑块位于初始位置时，得到鼠标按下时的水平位置
        var e = e || window.event;
        var downX = e.clientX;

        //3.显示图片
        canvaswapper.style.visibility = "visible";
        canvaswapper.style.opacity = 100;
        canvaswapper.style.transition = "opacity 0.75s";
        //三、给文档注册鼠标移动事件
        document.onmousemove = function (e) {

            var e = e || window.event;
            //1.获取鼠标移动后的水平位置
            var moveX = e.clientX;

            //2.得到鼠标水平位置的偏移量（鼠标移动时的位置 - 鼠标按下时的位置）
            var offsetX1 = moveX - downX;

            //3.在这里判断一下：鼠标水平移动的距离 与 滑动成功的距离 之间的关系
            if (offsetX1 > distance) {
                offsetX1 = distance;//如果滑过了终点，就将它停留在终点位置
            } else if (offsetX1 < 0) {
                offsetX1 = 0;//如果滑到了起点的左侧，就将它重置为起点位置
            }

            //4.根据鼠标移动的距离来动态设置滑块的偏移量和背景颜色的宽度
            block.style.transition = "left 0s ease";
            btn.style.left = offsetX1 + "px";
            bg.style.width = offsetX1 + "px";
            block.style.left = offsetX1 - 130 + "px";

            //如果鼠标的水平移动距离 = 滑动成功的宽度
            if (offsetX1 == distance) {

                // //1.设置滑动成功后的样式
                // text.innerHTML = "验证通过";
                // text.style.color = "#fff";
                // btn.innerHTML = "&radic;";
                // btn.style.color = "green";
                // bg.style.backgroundColor = "lightgreen";

                // //2.设置滑动成功后的状态
                // success = true;
                // //成功后，清除掉鼠标按下事件和移动事件（因为移动时并不会涉及到鼠标松开事件）
                // btn.onmousedown = null;
                // document.onmousemove = null;

                // //3.成功解锁后的回调函数
                // setTimeout(function(){
                //     alert('解锁成功！');
                // },100);
            }
        }

        //四、给文档注册鼠标松开事件
        document.onmouseup = function (e) {
            var block_left = (block.style.left).substring(0, (block.style.left).length - 2);
            //验证成功
            if (block_left > -2 && block_left < 2 && block_left != "") {
                //1.设置滑动成功后的样式
                text.innerHTML = "";
                text.style.color = "#fff";
                btn.style.color = "green";
                bg.style.backgroundColor = "lightgreen";

                //2.设置滑动成功后的状态
                success = true;
                slideResult = true;
                
                //成功后，清除掉鼠标按下事件和移动事件（因为移动时并不会涉及到鼠标松开事件）
                btn.onmousedown = null;
                document.onmousemove = null;
                document.onmouseup = null;

                //图片隐藏
                canvaswapper.style.opacity = 0;
                canvaswapper.style.transition = "opacity 0.75s";
                setTimeout(function () {
                    canvaswapper.style.visibility = "hidden";
                }, 750);

                //3.成功解锁后的回调函数
            }

            //如果鼠标松开时，滑到了终点，则验证通过
            if (success) {
                return true;
            } else {
                //反之，则将滑块复位（设置了1s的属性过渡效果）
                btn.style.left = 0;
                bg.style.width = 0;
                block.style.left = -130 + 'px';
                btn.style.transition = "left 1s ease";
                bg.style.transition = "width 1s ease";
                block.style.transition = "left 1s ease";
                
            }
            //只要鼠标松开了，说明此时不需要拖动滑块了，那么就清除鼠标移动和松开事件。
            document.onmousemove = null;
            document.onmouseup = null;

            //图片隐藏
            canvaswapper.style.opacity = 0;
            canvaswapper.style.transition = "opacity 1s";
            setTimeout(function () {
                canvaswapper.style.visibility = "hidden";
            }, 1000);
        }
    }
}
slide();

