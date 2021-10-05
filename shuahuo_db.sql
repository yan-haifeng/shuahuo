/*
 Navicat Premium Data Transfer

 Source Server         : myProject
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : shuahuo_db

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 27/08/2019 15:32:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `dynamic_id` int(11) NULL DEFAULT NULL,
  `u_id` int(11) NULL DEFAULT NULL,
  `comment_text` varchar(140) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_creation_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (24, 14, 3, '欢迎', '2019-08-26 20:51:26');
INSERT INTO `comment` VALUES (25, 14, 4, '欢迎', '2019-08-26 21:03:02');

-- ----------------------------
-- Table structure for dynamic
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic`  (
  `dynamic_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NULL DEFAULT NULL,
  `dynamic_text` varchar(140) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dynamic_imgnum` int(11) NULL DEFAULT 0,
  `dynamic_imgname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dynamic_videonum` int(11) NULL DEFAULT 0,
  `dynamic_videoname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dynamic_creation_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dynamic_dianzan_num` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`dynamic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
INSERT INTO `dynamic` VALUES (14, 3, '欢迎来到耍货:taikaixin:', 1, '##201908262050_yYyRdFkN.jpg', 0, '', '2019-08-26 20:51:01', 2);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `toys_id` int(11) NOT NULL,
  `studio_id` int(255) NOT NULL,
  `order_requirements` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_transaction_mode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_statu` int(11) NULL DEFAULT 0,
  `order_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (9, 8, 1, 25, '速度', '2500', '0', 0, '##201908262113_EyKhbbby.png');

-- ----------------------------
-- Table structure for studio
-- ----------------------------
DROP TABLE IF EXISTS `studio`;
CREATE TABLE `studio`  (
  `studio_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studio_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studio_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studio_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studio_begoodat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studio_othertypes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studio_uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`studio_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studio
-- ----------------------------
INSERT INTO `studio` VALUES (25, '金誉工作室', '201908262054_wdenH3a7.png', '##20190826211_4nACiANt.jpg##20190826211_Ab2TnS3Z.jpg', '90后原创工作室', '##0##8', '相信我', '96b8b4c3-b83a-40e1-94d2-1835c2db0c77');
INSERT INTO `studio` VALUES (26, '新玛工作室', '201908262103_HbchMDWX.png', '##20190826213_NR5j5jmw.jpg##20190826213_CAeHBwFF.jpg', '你需要我，我就出现', '##2##3##4', '啊啊', '4d4e5e90-c234-4f1f-b9a9-85cc45585fac');
INSERT INTO `studio` VALUES (27, '毛驴工作室', '201908262105_QnASZTMW.png', '##20190826215_2ZFwpG6c.jpg##20190826215_eQHdaJpT.jpg', '毛驴出马，一个顶俩', '##1##8', '啊啊啊', '7277432d-608b-4b1c-a761-0a4b1ab39930');

-- ----------------------------
-- Table structure for studio_member
-- ----------------------------
DROP TABLE IF EXISTS `studio_member`;
CREATE TABLE `studio_member`  (
  `studio_member_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio_id` int(11) NOT NULL,
  `studio_member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studio_member_id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studio_member_phone_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studio_member_record` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studio_member_head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`studio_member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studio_member
-- ----------------------------
INSERT INTO `studio_member` VALUES (11, 25, '小a', '535412156456456125', '1288888888', 'aaa', '201908262055_2FhHw353.jpg');
INSERT INTO `studio_member` VALUES (12, 26, '小AA', '50215888412455', '123123123123', '1111', '201908262104_jzeeaCp3.jpg');
INSERT INTO `studio_member` VALUES (13, 27, '小B', '12412312321', '12321321321', '123213', '201908262105_SfmZMFnJ.jpg');

-- ----------------------------
-- Table structure for toys
-- ----------------------------
DROP TABLE IF EXISTS `toys`;
CREATE TABLE `toys`  (
  `toys_id` int(11) NOT NULL AUTO_INCREMENT,
  `toys_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`toys_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of toys
-- ----------------------------
INSERT INTO `toys` VALUES (1, '猴子爬杆');
INSERT INTO `toys` VALUES (2, '燕车');
INSERT INTO `toys` VALUES (3, '竹节蛇');
INSERT INTO `toys` VALUES (4, '推磨人');
INSERT INTO `toys` VALUES (5, '小鸡啄米');

-- ----------------------------
-- Table structure for toys_agoandnow
-- ----------------------------
DROP TABLE IF EXISTS `toys_agoandnow`;
CREATE TABLE `toys_agoandnow`  (
  `toys_agoandnow_id` int(11) NOT NULL AUTO_INCREMENT,
  `toys_id` int(11) NOT NULL,
  `toys_agoandnow_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toys_agoandnow_img_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toys_agoandnow_img_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toys_agoandnow_img_context` varchar(4080) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`toys_agoandnow_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of toys_agoandnow
-- ----------------------------
INSERT INTO `toys_agoandnow` VALUES (1, 1, '从“猴子爬竿”说起', 'Monkey_climbing_pole1.jpg', 'Monkey_climbing_pole2.jpg', '有这样一道趣味题：\r \r 一根竹竿5段，小猴爬竿，每次上两段下一段。这只小猴几次能爬到竹竿顶上？\r \r 此题让学生先独自完成，检查时发现很多小朋友做错了，答案写成：这只小猴5次能爬到竹竿顶上。究竟是什么原因呢？课间，我问了几个学生，他们理解为：每次上两段下一段，其实就是“每次上一段”，5段就需要5次才能爬上竹竿顶。原来问题就出在最后一次爬竿上。怎样让学生理解此题？我仔细思考。\r \r 其实，此题为广为流传的“青蛙爬井”问题：看起来小猴每次只往上爬2- 1= 1（段），但爬了3次后，它再爬一次，往上爬了两段已到达竹竿顶上，因此这只小猴4次能爬到竹竿顶上。而这种思路不宜直接教授给一年级的孩子，根据低年级学生以形象思维为主的特点，应该把抽象的数学语言用直观的图形表达出来。');
INSERT INTO `toys_agoandnow` VALUES (2, 2, '燕车简介', 'Butterfly_car1.jpg', 'Butterfly_car2.jpg', '作为民间美术、民间玩具的一种,木旋玩具也一样,显然早已呈现出日薄西山的颓势。同时,近年来中国玩具产业的崛起以及中国风、民族风的回归,给木旋玩具当代的新生创造了前所未有的条件。当然,机遇与挑战并存,在木旋玩具革新的道路上能否一路畅通,关键在于木旋玩具能否在保持自己本质特色的基础上融入新的时代元素,满足大众审美需求。木旋玩具的产生既有历史的偶然性也有合理的必然性,沂河岸边丰茂的植被给木旋玩具的生产提供了材料保障,后经历代能工巧匠数百年不断革新,旋制工艺日渐成熟,出现了一批批富有代表性的木旋玩具。把握其工艺、审美、功能、科技原理等本体特征更有助于我们全面地、深刻地认识木旋玩具,这些本体特征中既有民间美术所共有的特点,也有木旋玩具所独有的特点,其审美特征与中国民间审美理念一脉相承。由于时间的积淀,今天这些玩具的功能性也不再单一,俨然已具有文化属性、审美属性等,不少木旋玩具还蕴含着丰富的科学原理,是古代科技文化成果的展示,也是现在值得我们探讨的一方面。然而今天,木旋玩具同样遇到了传统与现代、手工与机械的选择难题,发展状况不容乐观。因此,要结合当代玩具市场,深入分析在木旋玩具的缺陷,从自身优势出发并参照其他木制玩具成功案例,分析木旋玩具未来发展趋势的可行性,最后从设计角度出发,为木旋玩具的创新发展寻找突破口。                                                                                  --来源知网');
INSERT INTO `toys_agoandnow` VALUES (3, 3, '竹节蛇', 'Snake1.jpg', 'Snake2.jpg', ' “竹节蛇”是用一小节一小节竹节做的。蛇眼放绿光，有芯，红色。捏住蛇头，捻动，蛇身还能游摆，竹节发出响声，逼真得很。\r\n 把竹子切成一段段的竹管後，再连结成长串的蛇身，就可以作出栩栩如生的竹节蛇。注意竹管套接时必须由蛇尾开始，一段段地升高。握住蛇尾时，由于重心落在蛇头上，造成不平衡，所以蛇头会摇来晃去、左右摆动。\r\n也可以以一截较长的竹管做蛇身中段，分别朝头、尾叠高，如此只要握住中段，重心便会落在头、尾上，使两端晃动。');
INSERT INTO `toys_agoandnow` VALUES (4, 4, '推磨', 'Push_grinding1.jpg', 'Push_grinding2.jpg', '在没用上机器磨、电磨之前，北方吃粮食首先要用石磨把粮食（麦子、大豆、玉米等，谷黍类除外）磨成面，这个把粮食磨成面的过程很费力，有牲口的用牲口拉着磨，没有牲口的就得用人推。所以，磨面的过程又叫“推磨”。\r\n\r\n推磨是在过去农村生活当中必不可少的一件事，只不过现在已见不到了。我们那时候把推磨叫赶“圈集”。在过去的农村生活中，每家都有一个最基本的家产就是“磨”。它是我记忆当中最不能望记的事。我知道我是吃煎饼长大的，要说煎饼，大多人们都知道，街上买的菜煎饼、面煎饼、高梁煎饼、麦子煎饼等等多种多样，谁都能说出个一二三来。可我说的煎饼是用“磨”推后摊出来的煎饼。\r\n磨，现在只有在农村的农家小院也许能够见到，但大多因时间的过迁都不在保留它了。偶尔在农家的不显眼出你才能发现。磨的结构很简单，就是两个团团圆圆的大石轮，上薄下厚抠在一起，中间有一柱心，上轮为公以柱心为圆，全圈上突约1公分的磨赤，下轮为母全圈凹下约1 公分的赤沟，上赤下沟的相互来回压济形成合力助成一起，就构造成了我们说的磨了。\r\n二十世纪四五十年代，家乡人吃的面粉几乎全都靠磨加工而成。\r\n磨由磨盘和磨扇组成。磨盘是个支起来的由两个半圆形石板儿拼成的圆形工作平台，其直径5尺至6尺，石板儿厚2寸至4寸，高2尺多，通常由青石(石灰岩)或者红砂岩(页岩)制成。\r\n\r\n磨扇分上扇、下扇：下扇工作面朝上，其工作面中心镶嵌一个短轴，俗名“磨脐儿”；上扇的工作面朝下，中心有轴孔，与下扇的磨脐儿配合，形成轴承，用以支持磨的稳定运转。上扇以中心点为对称中心，相隔180度有两个磨眼儿，这是下粮食的通道，根据需要，两个磨眼儿可同时开启，也可堵住一个，以调节粮食下漏的速度。');
INSERT INTO `toys_agoandnow` VALUES (5, 5, '原理介绍', 'Chickens_peck_at_rice1.jpg', 'Chickens_peck_at_rice2.jpg', '原理介绍：\r\n1关系转换理论的概述编辑关系转换理论是格式塔心理学家1929年提出的学习迁移理论。\r\n\r\n格式塔心理学家从理解事物关系的角度对经验类化的迁移理论进行了重新解释，代表人物是苛勒(W.Kohler)。 　　苛勒(Kohler,W.，1929)用“小鸡啄米实验”证明了关系转换的学习迁移理论。他让小鸡在深、浅不同的两种灰色的纸下面寻找食物。通过条件反射学习，小鸡学会了只有从深灰色纸下才能获得食物奖赏。然后，变换实验情境，保留原来的深灰色纸，用黑色纸取代浅灰色纸。现在的问题是：如果小鸡仍然到深灰色纸下面寻找食物，那就证明迁移是由于相同要素的作用；如果小鸡是到两张纸中颜色更深的那张(即黑色纸)下面寻找食物，那就证明迁移是对关系作出的反应。\r\n\r\n实验表明：小鸡对新刺激(黑色纸)的反应为70%，对原来的阳性刺激(深灰色纸)的反应是30%；而幼儿在做同样的实验时始终对黑色纸的刺激作出反应。他认为这结果证明是情景中的关系对迁移起了作用，而不是其中的相同要素，被试选择的不是刺激的绝对性质而是比较其相对关系(把在前一种情景中学会的关系即“食物总是在颜色较深的纸下面”迁移到后一种情景中，从而做出了正确的反应)。苛勒通过实验证明迁移产生的实质是个体对事物间的关系的理解。即迁移的产生依赖于两个条件：一是两种学习之间存在有一定的关系；二是学习者对这一关系的理解和顿悟。其中后者比前者重要。习得的经验能否迁移，并不取决于是否存在某些共同的要素，也不取决于对原理的孤立的掌握，而是取决于个体能否理解各个要素之间形成的整体关系，能否理解原理与实际事物之间的关系，即对情境中一切关系的理解和顿悟是获得一般迁移的最根本要素和真正手段。苛勒认为，人们越能发现事物之间关系，则越能加以概括、推广，迁移越普遍。\r\n\r\n2关系转换理论的评价编辑这个理论可以认为是概括化理论的继续与发展。他们并不否认学习依赖于学习原理的迁移，但他们强调“顿悟 ”(insight)是迁移的一个决定因素，认为迁移不是由两个学习情境具有共同要素、原理或规则而自动产生的某种东西，而是由于学习者突然发现两个学习经验之间存在着关系的结果，也就是说学习者领悟学习情境中的关系是实现迁移的根本条件。 　　人所迁移的是顿悟——两个情境突然被联系起来的意识。对情境中的一切关系的顿悟是迁移的实质。顿悟指的是对事物之间的关系的基本认识或感受。经过检验而概括化的顿悟便是理解。与前几个迁移理论不同，关系转换说更加强调学习者个体的作用。苛勒对迁移的研究和贾德的观点不谋而合，他们都认为对事物的内在组织的理解是迁移的基础，即理解力越强，对总的情境的知觉就越完善，概括化的可能性也越大。');

-- ----------------------------
-- Table structure for toys_exhibition
-- ----------------------------
DROP TABLE IF EXISTS `toys_exhibition`;
CREATE TABLE `toys_exhibition`  (
  `toys_exhibition_id` int(11) NOT NULL AUTO_INCREMENT,
  `toys_id` int(11) NOT NULL,
  `toys_img_exhibition_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toys_img_exhibition_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toys_img_exhibition_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toys_img_exhibition_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toys_img_exhibition_five` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toys_img_exhibition_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`toys_exhibition_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of toys_exhibition
-- ----------------------------
INSERT INTO `toys_exhibition` VALUES (1, 1, 'Monkey_climbing_pole_main.png', 'Monkey_climbing_pole_before.png', 'Monkey_climbing_pole_after.png', 'Monkey_climbing_pole_left.png', 'Monkey_climbing_pole_top.png', '../../toy_model/Monkey_climbing_pole/index.html');
INSERT INTO `toys_exhibition` VALUES (2, 2, 'Butterfly_car_main.png', 'Butterfly_car_before.png', 'Butterfly_car_after.png', 'Butterfly_car_left.png', 'Butterfly_car_top.png', '../../toy_model/Butterfly_car/index.html');
INSERT INTO `toys_exhibition` VALUES (3, 3, 'Snake_main.png', 'Snake_before.png', 'Snake_after.png', 'Snake_left.png', 'Snake_top.png', '../../toy_model/Snake/index.html');
INSERT INTO `toys_exhibition` VALUES (4, 4, 'Push_grinding_main.png', 'Push_grinding_before.png', 'Push_grinding_after.png', 'Push_grinding_left.png', 'Push_grinding_top.png', '../../toy_model/Push_grinding/index.html');
INSERT INTO `toys_exhibition` VALUES (5, 5, 'Chickens_peck_at_rice_main.png', 'Chickens_peck_at_rice_before.png', 'Chickens_peck_at_rice_after.png', 'Chickens_peck_at_rice_left.png', 'Chickens_peck_at_rice_top.png', '../../toy_model/Chickens_peck_at_rice/index.html');

-- ----------------------------
-- Table structure for toys_memory
-- ----------------------------
DROP TABLE IF EXISTS `toys_memory`;
CREATE TABLE `toys_memory`  (
  `toys_memory_id` int(11) NOT NULL AUTO_INCREMENT,
  `toys_id` int(11) NULL DEFAULT NULL,
  `toys_memory_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toys_memory_img_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toys_memory_img_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toys_memory_img_context` varchar(4080) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`toys_memory_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of toys_memory
-- ----------------------------
INSERT INTO `toys_memory` VALUES (1, 1, '猴子爬杆', 'Monkey_climbing_pole1.jpg', 'Monkey_climbing_pole2.jpg', '只见张小采先将烙好的白面饼“噌噌噌”切成细条，然后把鸡蛋液与切好的饼条打匀，倒进油锅里，一起翻炒，最后，放入佐料，翻炒均匀。不一会，只见一盘猴子爬杆饼条出锅了，色泽金黄，松软鲜香。围观之食客，无不叫好称赞。张小采端着盘子走到老者面前，自信地说：“这份猴子爬杆，有虚有实，有动有静，也算是一道名菜。老人家您果然见识非凡。”但是老者看都没看这盘菜，就揶揄道：“你这就做好了？哼！果然还是欠火候。你这道菜，猴子有了，杆也有了，可我怎么没看到猴子爬杆呢？我要你现场做，个中奥秘，皆缘于此。而且，你这小猴，怎么连眼睛都没有啊，哈哈哈？”“这……”张小采哑口无言。“这真正的猴子爬杆，其实是这样的。”老者命伙计取来鲜虾、竹笋，佐料若干。老者提刀切笋，较于张小采，老者刀工更慢，更柔和，但切出来的笋条却十分整齐。老者将笋条倒入锅中，竹笋“噼噼啪啪”，一股沁人心脾的清香发散出来。这香味，相比之前的猴子爬杆，更具一股清凉芬芳之感。几分钟后，老人将炒好的竹笋收入盘中，然后他再起油锅，将佐料撒入锅中，霎时间，奇香四溢。接下来，老人又放入竹笋，炒拌均匀，再迅速将活虾倾盆倒入锅中，只见活虾受不住高温煎烤，虾脚自然弯曲，竟然正是抱住竹笋，向上蹿动。一双双小虾眼，真给人一种小猴在杆上玩耍的奇特感觉，却正像那“猴子爬杆”！“好！”不经意间，周围聚拢的人越来越多，潮水般的叫好声四面而来。老者将这盘真正的猴子爬杆放在张小采面前。');
INSERT INTO `toys_memory` VALUES (2, 2, '民间美术', 'Butterfly_car1.jpg', 'Butterfly_car2.jpg', '作为民间美术、民间玩具的一种,木旋玩具也一样,显然早已呈现出日薄西山的颓势。同时,近年来中国玩具产业的崛起以及中国风、民族风的回归,给木旋玩具当代的新生创造了前所未有的条件。当然,机遇与挑战并存,在木旋玩具革新的道路上能否一路畅通,关键在于木旋玩具能否在保持自己本质特色的基础上融入新的时代元素,满足大众审美需求。木旋玩具的产生既有历史的偶然性也有合理的必然性,沂河岸边丰茂的植被给木旋玩具的生产提供了材料保障,后经历代能工巧匠数百年不断革新,旋制工艺日渐成熟,出现了一批批富有代表性的木旋玩具。把握其工艺、审美、功能、科技原理等本体特征更有助于我们全面地、深刻地认识木旋玩具,这些本体特征中既有民间美术所共有的特点,也有木旋玩具所独有的特点,其审美特征与中国民间审美理念一脉相承。由于时间的积淀,今天这些玩具的功能性也不再单一,俨然已具有文化属性、审美属性等,不少木旋玩具还蕴含着丰富的科学原理,是古代科技文化成果的展示,也是现在值得我们探讨的一方面。然而今天,木旋玩具同样遇到了传统与现代、手工与机械的选择难题,发展状况不容乐观。因此,要结合当代玩具市场,深入分析在木旋玩具的缺陷,从自身优势出发并参照其他木制玩具成功案例,分析木旋玩具未来发展趋势的可行性,最后从设计角度出发,为木旋玩具的创新发展寻找突破口。 ');
INSERT INTO `toys_memory` VALUES (3, 3, '蛇对于浙江人的意义', 'Snake1.jpg', 'Snake2.jpg', '蛇对于浙江人的意义非同一般，可谓是情有独钟,浙江民俗中“龙为吴越文明的象征，神话传说中的龙管雨，《西游记》中的描写东海龙王有降雨的本领，因此人们尊崇龙以祈求风调雨顺。人们常以“蛇代龙”,认为蛇是活在民间的龙，因此蛇也有\r\n蛇对于浙江人的意义非同一般，可谓是情有独钟,浙江民俗中“龙为吴越文明的象征，神话传说中的龙管雨，《西游记》中的描写东海龙王有降雨的本领，因此人们尊崇龙以祈求风调雨顺。人们常以“蛇代龙”,认为蛇是活在民间的龙，因此蛇也有\r\n“小龙”之称。对于蛇的传说可以追溯到冯梦龙的《白娘子永镇雷峰塔》。\r\n\r\n清朝中后期方成培的《雷峰塔传奇》，西子湖畔白蛇的美好传说家喻 户晓，人们纷纷赞扬白娘子敢于挣脱世俗枷锁，追求自由爱情的精神，激发了人们无限的想象与向往。\r\n民间对于蛇的模仿和传承，让这一种原本是望而生畏的动物变得格外惹人\r\n喜爱，特别是那些妙趣横生的“蛇”玩具，老少皆宜，制作精美，甚是独特。\r\n\r\n其中最广为人知的当属‘竹节蛇”了。它是串联而成的竹龙,在浙江的民间颇为流行，到现在还是遍布街市，身受孩子们喜爱。其主要特点在于设计精巧，生动传神。回想起儿童时代,手里握着竹节蛇和小伙伴们互相嬉戏打闹，或是恶作剧捉弄胆小\r\n的女生,每当听到她们惊吓的尖叫声，就特别过瘾刺激笑的合不拢嘴。');
INSERT INTO `toys_memory` VALUES (4, 4, '推磨', 'Push_grinding1.jpg', 'Push_grinding2.jpg', '老家的石磨是祖上传下来的，当年左邻右舍经常预约使用，简陋的石磨忙碌不断，这足以让一生贫困的父母感到一丝欣慰和自豪。\r\n\r\n几十年过去了，母亲推着比她还要重的石磨的情景不时浮现在眼前，她左脚在前，右脚在后，两手紧握磨手，拉磨时，身子向后一仰，磨手向右一折，再推磨，身子向前倾俯，磨手经右前方朝左前方一拐停下，用纤巧的手抓一把粮食摇晃着送进磨眼，擦一把额头上的汗水，再拉磨，长年累月，两脚踩的地方踩出了两个泥坑。\r\n\r\n在困难的年月，我经常挨饿，只要听到石磨一响，就有了希望，就是这石磨把一个个艰难的日子打发了。母亲常把少量粮食用这石磨磨一磨，将磨出的粉子与野菜一起掺和，做成菜粑粑吃，或者煮成糊糊吃。有时青黄不接时，田里包谷才刚抽红须就弄了下来，将整个包谷棒子切成小块，放在磨里打成包谷浆，维持几天。\r\n\r\n白天父母要参加集体劳动挣工分，推磨的活大都放在晚上做。三十斤左右的包谷，石磨吞吐大约需要三个多小时，等到活干完已是深夜。\r\n\r\n小时我最怕的是推磨，记不清是多大年纪就帮父母推磨了。开始时推着磨撒欢地跑着，可一会儿就累得气喘吁吁，只好又慢慢地推下去。有时为了图快，就在磨眼多放些包谷，虽然磨的吞吐快了，但出的面粉粗，又不得不再推一遍。最让人不痛快的是那十分呆板单调地推圈圈，伴着那像闷雷样的声音，几个小时下来，就让人头晕目眩。邻居有我一位好友，小时认为做作业好像比推磨还痛苦，偶尔我就帮他做作业，他就替我推磨。\r\n\r\n别看那石磨难推，可在那困难的年月，经常有磨推的机会好像还是一份荣耀，因为那时普遍少粮，不少家里在粮荒的月份是靠采野菜度日。有一年，我家里没粮了，父母只找邻里借了一些包谷。兄弟俩一见到包谷，高兴地不得了，一齐上帮忙推磨，可能真的是饿坏了，有点等不及了。只见母亲的眼泪不自主地就流了出来。有粮食的兴奋伴随着石磨的旋转，生活的希望伴随着我们成长……。\r\n\r\n如今我对包谷饭仍有特殊的情感，是它曾经救过我的命，好像我的每根骨头都有包谷饭的香味，难忘那推磨的苦与乐。\r\n\r\n今天家乡都用上了机器磨，石磨早已成了古董，有的则成了游人们景点。现在想起来推磨就像现在健身房的拉臂力的健身器，向前推，向后拉，多少有点推磨的感觉，只是没推磨那么刺激，不得已为之，而现在是为了健身或乐趣。\r\n\r\n我老家石磨仍然放在那儿，近几十年几乎没用过，有几次整理房间，想把这石磨丢掉，母亲总是不让。母亲说，等我们不在人世了你们再丢吧。每当我见到那石磨，就想起具有保健作用包谷饭，还有那农人艰辛，是让我永远不要忘记，不管走到哪儿都是农民的儿子。');
INSERT INTO `toys_memory` VALUES (5, 5, '小鸡啄米的小故事', 'Chickens_peck_at_rice1.jpg', 'Chickens_peck_at_rice2.jpg', '有个农夫人家养了一只小鸡，喂养小鸡，就掏出一把米放在地上，按住小鸡的头，强迫它吃米，可是小鸡不吃。他又撕开鸡嘴，把米硬往鸡的嘴里灌，小鸡拼力挣扎。后来主人轻轻地松开手，把小鸡放开了，撒了一些米，自己向后退了几步。一会儿，小鸡自己啄起米来。');

-- ----------------------------
-- Table structure for user_form
-- ----------------------------
DROP TABLE IF EXISTS `user_form`;
CREATE TABLE `user_form`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `county` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `sex` int(11) NULL DEFAULT 0 COMMENT '性别',
  `age` int(11) NULL DEFAULT 0 COMMENT '年龄',
  `phonenum` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `qqnum` int(11) NULL DEFAULT NULL COMMENT 'qq号',
  `e_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱号',
  `occupation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业类型',
  `correlation_for_handicraft` int(11) NULL DEFAULT 0 COMMENT '与手工业相关性',
  `personality_label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '个性标签',
  `headimg_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像图片名字',
  `studio_id` int(11) NULL DEFAULT 0 COMMENT '工作室id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phonenum`(`phonenum`) USING BTREE COMMENT '手机号唯一',
  UNIQUE INDEX `username`(`username`) USING BTREE COMMENT '账号唯一',
  UNIQUE INDEX `e_mail`(`e_mail`) USING BTREE COMMENT '邮箱号唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_form
-- ----------------------------
INSERT INTO `user_form` VALUES (3, '1131368173', '123456', '测试账号', '海外', '美国', '', 0, 4, '123', 88888888, '123', '1', 2, '测试', '3headimg.jpg', 25);
INSERT INTO `user_form` VALUES (4, '1992306139', '123456', '小A', '', '', '', 1, 0, '15355036848', 0, '1992306139@qq.com', '', 0, '', '4headimg.jpg', 26);
INSERT INTO `user_form` VALUES (8, 'guest', 'guest', 'guest', '浙江省', '杭州市', '滨江区', 0, 0, NULL, 0, NULL, '0', 0, '', '8headimg.jpg', 27);

SET FOREIGN_KEY_CHECKS = 1;
