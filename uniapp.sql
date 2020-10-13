/*
 Navicat Premium Data Transfer

 Source Server         : test2
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : uniapp

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 29/06/2020 21:14:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_books
-- ----------------------------
DROP TABLE IF EXISTS `tb_books`;
CREATE TABLE `tb_books`  (
  `book_id` int(0) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `book_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `book_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_books
-- ----------------------------
INSERT INTO `tb_books` VALUES (1, '写过爱过活过', '李银河', 'http://localhost:8087/s/images/booksImg/xieguoaiguohuoguo.jpg', '社会学家李银河新版自传——一位女性主义者的人生自述，坦荡、独立、勇敢、自由，一生所求不过爱与美。生于1950年代，经历“文革”、上山下乡、工农兵学员、公派留学……李银河成长中的苦闷彷徨和命运转折，带有鲜明的时代烙印，是那一代知识分子从理想狂热走向独立思考，再到致力于社会进步的缩影。成长、爱情、学术在李银河生命中占据着重要的位置。在人生的这三个向度上，她“像蜜蜂采蜜一样”，只采撷最精华的部分。', 'www.gxbgsx.com/ebook/show-27440.html');
INSERT INTO `tb_books` VALUES (2, '平凡的世界', '路遥', 'http://localhost:8087/s/images/booksImg/pingfandeshijie.jpg', '一部现实主义小说，也是一部小说形式的家族史。作者浓缩了中国西北农村的历史变迁过程，在小说中全景式地表现了中国当代城乡的社会生活。在近十年的广阔背景下，通过复杂的矛盾纠葛，刻划社会各阶层众多普通人的形象。劳动与爱情，挫折与追求，痛苦与欢乐，日常生活与巨大社会冲突，纷繁地交织在一起，深刻地展示了普通人在大时代历史进程中所走过的艰难曲折的道路。', 'http://www.pingfandeshijie.net/');
INSERT INTO `tb_books` VALUES (3, '骆驼祥子', '老舍', 'http://localhost:8087/s/images/booksImg/luotuoxiaangzi.jpg', '老舍用同情的笔触描绘的一幕悲剧：二十年代的北京，一个勤劳、壮实的底层社会小人物怀着发家、奋斗的美好梦想，却最终为黑暗的暴风雨所吞噬。它揭示了当时“小人物”的奴隶心理和希望的最终破灭。随着祥子心爱的女人小福子的自杀，祥子熄灭了个人奋斗的最后一朵火花。这是旧中国老北京贫苦市民的典型命运。', 'https://www.kanshuhai.com/0/73/73882/?btwaf=75500095');
INSERT INTO `tb_books` VALUES (4, '朱一龙写真集', '朱一龙', 'http://localhost:8087/s/images/booksImg/zhuyilong.jpg', '该本写真集拍摄于澳大利亚悉尼，在新州旅游局支持下，顺利于悉尼歌剧院、海港大桥、皇家植物园、帕丁顿水库、史蒂芬港、La Perouse港湾、悉尼情人港等11地取景。首本写真集对朱一龙而言是一次全新的体验与尝试，全集收录150多张高清大图，通过摄影师的镜头记录，真实的展露了其在这段旅程中的不同状态。', 'https://zhuanlan.zhihu.com/p/79997965');
INSERT INTO `tb_books` VALUES (5, '活着', '余华', 'http://localhost:8087/s/images/booksImg/huozhe.jpg', '讲述了农村人福贵悲惨的人生遭遇。福贵本是个阔少爷，可他嗜赌如命，终于赌光了家业，一贫如洗。他的父亲被他活活气死，母亲则在穷困中患了重病，福贵前去求药，却在途中被国民党抓去当壮丁。经过几番波折回到家里，才知道母亲早已去世，妻子家珍含辛茹苦地养大两个儿女。此后更加悲惨的命运一次又一次降临到福贵身上，他的妻子、儿女和孙子相继死去，最后只剩福贵和一头老牛相依为命，但老人依旧活着，仿佛比往日更加洒脱与坚强。', 'https://www.xyyuedu.com/xdmz/huozhe/');
INSERT INTO `tb_books` VALUES (6, '撒野', '巫哲', 'http://localhost:8087/s/images/booksImg/saye.jpg', '我想，左肩有你，右肩微笑。我想，在你眼里，撒野奔跑，我想，一个眼神，就到老。', 'http://www.jjwxc.net/onebook.php?novelid=2956313');
INSERT INTO `tb_books` VALUES (7, '从你的全世界路过', '张嘉佳', 'http://localhost:8087/s/images/booksImg/luguo.jpg', '最初以“睡前故事”系列的名义在网上疯狂流传，几天内达到1,500,000 次转发，超4亿次阅读，引来电影投资方的巨资抢购，转瞬便签下其中5个故事的电影版权。每1分钟，都有人在张嘉佳的故事里看到自己。', 'https://www.xstt5.com/dangdai/8456/');
INSERT INTO `tb_books` VALUES (8, '梦里花落知多少', '三毛', 'http://localhost:8087/s/images/booksImg/hualuozhiduoshao.jpg', '《梦里花落知多少》是三毛后期作品集，主要记录了三毛在荷西死后悲痛的心情和慢慢走出阴霾的过程。全书萦绕着伤感的气氛，是三毛后期风格的一大代表。', 'https://www.luoxia.com/menglihualuo/');
INSERT INTO `tb_books` VALUES (9, '无羁', '墨香铜臭', 'http://localhost:8087/s/images/booksImg/wuji.jpg', '夷陵老祖魏无羡，前世受万人唾骂，声名狼藉。被情同手足的师弟带人端了老巢，纵横一世，死无全尸。十三年后，被人以禁术强行召回世上，竟沦为一名受尽欺压折辱的疯人，卷入一桩诡异的五马分尸奇案！在曾与自己\"水火不容\"的仙门名士蓝忘机结伴同行的路上，往事风云再起。', 'www.qxswk.com/xh/26876/');
INSERT INTO `tb_books` VALUES (10, '一个人的好天气', '(日)青山七惠', 'http://localhost:8087/s/images/booksImg/one.jpg', '一个打零工的女孩如何与年长亲人相处，同时追寻自我、独立的故事，走向自立的一名女孩在工作、生活和恋爱中的种种际遇和心情令人揪心，小说写尽了做一名自由职业者（“飞特族”）的辛酸。内容折射出当前日本的一个社会问题，即许多年轻人不愿投入全职工作而四处打工，宁愿做自由职业者，他们不想长大，不愿担负责任，无法独立，害怕走出去看看这个世界，但是又不知道这种恐惧从何而来。', 'http://www.99csw.com/book/1955/index.htm');

-- ----------------------------
-- Table structure for tb_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_userinfo`;
CREATE TABLE `tb_userinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_pw` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'http://localhost:8087/s/images/login.png',
  `like_list` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
  PRIMARY KEY (`id`, `user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_userinfo
-- ----------------------------
INSERT INTO `tb_userinfo` VALUES (1, '123', '123', 'http://localhost:8087/s/images//headImg/userId-1.png', '[3,4,10]');
INSERT INTO `tb_userinfo` VALUES (3, 'test', 'test', 'http://localhost:8087/s/images//headImg/userId-3.o6zAJsxz7VsWczwbekRXQlVIOaxc', '[1,5]');
INSERT INTO `tb_userinfo` VALUES (10, 'test22', 'test22', 'http://localhost:8087/s/images//headImg/userId-10.o6zAJsxz7VsWczwbekRXQlVIOaxc', '');
INSERT INTO `tb_userinfo` VALUES (11, '456', '123789', 'http://localhost:8087/s/images//headImg/userId-11.o6zAJsxz7VsWczwbekRXQlVIOaxc', '');
INSERT INTO `tb_userinfo` VALUES (12, 'lixu', 'password', 'http://localhost:8087/s/images/login.png', '');
INSERT INTO `tb_userinfo` VALUES (13, 'hello', 'helloo', 'http://localhost:8087/s/images//headImg/userId-13.png', '[1,7,10,8,5]');
INSERT INTO `tb_userinfo` VALUES (14, 'register', '123456', 'http://localhost:8087/s/images/login.png', '');

SET FOREIGN_KEY_CHECKS = 1;
