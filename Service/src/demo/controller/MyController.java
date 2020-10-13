package demo.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import demo.pojo.*;
import demo.service.BookService;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
/*
    @RequestMapping("/search")
    @ResponseBody
    public Data<SearchData> search(String keyWord, Integer page, Integer pageSize, HttpServletResponse response){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Data<SearchData> result =null;
        List<BooksData> booksDataList =  getSearchResult(keyWord);
        SearchData searchData= new SearchData();
        List<SearchData> searchDataList =new ArrayList<>();
        searchData.setPage(page);
        if (booksDataList !=null){
            System.out.println(booksDataList.size());
            searchData.setTotal(booksDataList.size());
            List<BooksData> backList =new ArrayList<>();
            if (booksDataList.size()>pageSize){
                if (page*pageSize<booksDataList.size()){
                    for (int i=(page-1)*pageSize;i<page*pageSize;i++){
                        backList.add(booksDataList.get(i));
                    }
                } else {
                    for (int i=(page-1)*pageSize;i<booksDataList.size();i++){
                        backList.add(booksDataList.get(i));
                    }
                }
            }else{
                for (int i=0;i<booksDataList.size();i++){
                    backList.add(booksDataList.get(i));
                }
            }
            searchData.setSearchList(backList);
//            List<SearchData> searchDataList =new ArrayList<>();
            searchDataList.add(searchData);
            result=new Data<>(200,"ok",searchDataList);
        }else {
            result=new Data<>(200,"no",searchDataList);
        }

        return result;

    }

    public List<BooksData> getSearchResult(String keyWord) {
        BooksData b1 = new BooksData("http://localhost:8086/BookServer_war_exploded/image/book-1.jpg",
                "写过爱过活过",
                "社会学家李银河新版自传——一位女性主义者的人生自述，坦荡、独立、勇敢、自由，一生所求不过爱与美。生于1950年代，经历“文革”、上山下乡、工农兵学员、公派留学……李银河成长中的苦闷彷徨和命运转折，带有鲜明的时代烙印，是那一代知识分子从理想狂热走向独立思考，再到致力于社会进步的缩影。成长、爱情、学术在李银河生命中占据着重要的位置。在人生的这三个向度上，她“像蜜蜂采蜜一样”，只采撷最精华的部分。",
                8.7f);
        b1.setId(1);
        BooksData b2 = new BooksData("http://localhost:8086/BookServer_war_exploded/image/book-2.jpg",
                "平凡的世界",
                "《平凡的世界》是一部现实主义小说，也是一部小说形式的家族史。作者浓缩了中国西北农村的历史变迁过程，在小说中全景式地表现了中国当代城乡的社会生活。在近十年的广阔背景下，通过复杂的矛盾纠葛，刻划社会各阶层众多普通人的形象。劳动与爱情，挫折与追求，痛苦与欢乐，日常生活与巨大社会冲突，纷繁地交织在一起，深刻地展示了普通人在大时代历史进程中所走过的艰难曲折的道路。",
                8.2f);
        b2.setId(2);
        BooksData b3 = new BooksData("http://localhost:8086/BookServer_war_exploded/image/book-3.jpg",
                "当你又忙又美，何惧患得患失",
                "不行就分，喜欢就买，最坏不过重启试试，没有过不去的坎。看到手机电量不足10%，急也没用，你还得一格一格地充电，人生也是。二十多年的光景足够慢炖一个姑娘，无须八角茴香，文火收汤。",
                8.2f);
        b3.setId(3);
        BooksData b4 = new BooksData("http://localhost:8086/BookServer_war_exploded/image/book-4.jpg",
                "朱一龙写真集",
                "该本写真集拍摄于澳大利亚悉尼，在新州旅游局支持下，顺利于悉尼歌剧院、海港大桥、皇家植物园、帕丁顿水库、史蒂芬港、La Perouse港湾、悉尼情人港等11地取景。首本写真集对朱一龙而言是一次全新的体验与尝试，全集收录150多张高清大图，通过摄影师的镜头记录，真实的展露了其在这段旅程中的不同状态。",
                8.2f);
        b4.setId(4);
        BooksData b5 = new BooksData("http://localhost:8086/BookServer_war_exploded/image/book1.jpg",
                "飘",
                "《飘》(套装上下册)(Gone with the Wind)讲的是美国南部农场主杰拉尔德的女儿思嘉.奥哈拉",
                8.2f);
        b5.setId(5);
        List<BooksData> list = null;
        if (keyWord == null || keyWord.equals("")) {
            list = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                list.add(b1);
            }
            for (int i = 0; i < 15; i++) {
                list.add(b2);
            }
            for (int i = 0; i < 15; i++) {
                list.add(b3);
            }
            for (int i = 0; i < 15; i++) {
                list.add(b4);
            }
            for (int i = 0; i < 15; i++) {
                list.add(b5);
            }
            return list;
        }
        if (keyWord.contains("写过")) {
            list = new ArrayList<>();
            list.add(b1);
        }
        if (keyWord.contains("世界")) {
            list = new ArrayList<>();
            list.add(b2);
        }
        if (keyWord.contains("当你")) {
            list = new ArrayList<>();
            list.add(b3);
        }
        if (keyWord.contains("朱一龙")) {
            list = new ArrayList<>();
            list.add(b4);
        }
        if (keyWord.contains("飘")) {
            list = new ArrayList<>();
            list.add(b5);
        }
        return list;
    }
*/

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    private String localhost;//="http://localhost:8087/s/images/"

//    获取后台服务器地址
    public String getHost(){
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() +"/";
        return path;//http://localhost:8087/s/
    }

    //轮播列表
    @RequestMapping("/swiper")
    @ResponseBody
    public Data<SwiperData> getSwiperData(){
        localhost=getHost()+"images/";
        SwiperData m1 = new SwiperData(1,"三体全集","刘慈欣",localhost+"swiperBooks/santi.jpg","http://www.shizongzui.cc/santi/",
                "第一部《三体》\n" +
                        "文化大革命如火如荼地进行，天文学家叶文洁在其间历经劫难，被带到军方绝秘计划“红岸工程”。叶文洁以太阳为天线，向宇宙发出地球文明的第一声啼鸣，取得了探寻外星文明的突破性进展。三颗无规则运行的太阳主导下，四光年外的“三体文明”百余次毁灭与重生，正被逼迫不得不逃离母星，而恰在此时，他们接收到了地球发来的信息。对人性绝望的叶文洁向三体人暴露了地球的坐标，彻底改变了人类的命运。\n" +
                        "地球的基础科学出现了异常的扰动，纳米科学家汪淼进入神秘的网络游戏《三体》，开始逐步逼近这个世界的真相。汪淼参加一次玩家聚会时，接触到了地球上应对三体人到来而形成的一个秘密组织（ETO）。地球防卫组织中国区作战中心通过“古筝计划”，一定程度上挫败了拯救派和降临派扰乱人类科学界和其他领域思想的图谋，获悉处于困境之中的三体人为了得到一个能够稳定生存的世界决定入侵地球。\n" +
                        "在运用超技术锁死地球人的基础科学之后，庞大的三体舰队开始向地球进发，人类的末日悄然来临 \n"+
                        "第二部《三体Ⅱ·黑暗森林》\n" +
                        "三体人在利用科技锁死了地球人的科学之后，出动庞大的宇宙舰队直扑太阳系，面对地球文明前所未有的危局，人类组建起同样庞大的太空舰队，同时（PDC）利用三体人思维透明的致命缺陷，制订了“面壁计划”。出乎意料地，社会学教授罗辑被选出作为四位“面壁者”之一，展开对三体人的秘密反击。虽然三体人自身无法识破人类的计谋，却依靠由地球人中的背叛者挑选出的“破壁人”与“面壁者”进行智慧博弈。\n" +
                        "在这场你死我活的文明生存竞争中，罗辑由一开始的逃避和享乐主义逐渐意识到自己的责任，想到了一个对抗三体文明入侵的办法。科研军官章北海试图借一场陨石雨干涉飞船推进形式的研究方向。近二百年后，获选增援未来的他在人类舰队被“水滴”清除殆尽前，成功抢夺战舰逃离。此时罗辑证实了宇宙文明间的黑暗森林法则，任何暴露自己位置的文明都将很快被消灭。\n" +
                        "借助于这一发现，他以向全宇宙公布三体世界的位置坐标相威胁，暂时制止了三体对太阳系的入侵，使地球与三体建立起脆弱的战略平衡。 \n"+
                        "第三部《三体Ⅲ·死神永生》\n" +
                        "身患绝症的云天明买下一颗星星送给暗恋着的大学同学程心，而程心因参与（PIA）向三体舰队发射探测器的工作，却想让航天专业背景的他放弃安乐死，作为被执行人将大脑捐献给阶梯计划。与三体文明的战争使人类首次看到了宇宙黑暗的真相，地球文明因为黑暗森林打击的存在如临大敌，不敢在太空中暴露自己。在零道德的宇宙中发起黑暗战役的战舰被诱导返航，却受到有道德的地球文明审判。\n" +
                        "不称职的懦弱少女程心被选来充当掌握地球命运的执剑人，她因为罗辑的成功将这看作一项只需花费时间的任务，刚刚任职水滴就向地球发动攻击，程心为了忠于人性做出了错误的决定。在警示下继续逃离的“蓝色空间”号，受到具有发射引力波能力的“万有引力”号与两个同行的“水滴”追击，其上的人员进入四维空间摧毁水滴并占领了“万有引力”号，启动引力波广播向宇宙公布了三体星系的坐标。\n" +
                        "云天明与地球取得联系，通过讲述三个自己编创的童话故事，向程心透露大量情报；人类自以为悟出了生存竞争的秘密，开始进行掩体计划，维德领导的空间曲率驱动研究因为程心的错误判断被终止，使得人类最终没有能够逃脱被高级文明毁灭的命运。因为宇宙中还存在更强大的文明，战争的方式和武器已经远超出人类的想象，极高文明发出了一张卡片大小的“二向箔”，使整个太阳系压缩为二维平面而毁灭。\n" +
                        "在地球人类接近灭亡之际，只有程心和艾AA两个幸存者乘坐光速飞船离开。罗辑成为设置于冥王星的地球文明博物馆的“守墓人”，她们在冥王星带走人类文明的精华。在云天明送的恒星的一颗行星上，程心遇到关一帆且探讨了宇宙降维的真相，然而超乎一切之上的力量要求宇宙归零重生，在黑域中穿越长达1800万年的时空……程心没有等到云天明到来，和关一帆在小宇宙中短暂居住后重新进入大宇宙生活。");
        SwiperData m2 = new SwiperData(2,"孤岛疑云","林苑中",localhost+"swiperBooks/gudaoyiyun.jpg","http://www.ireader.com/index.php?ca=bookdetail.index&bid=11050641",
                "一位致力于生物学研究的教授带着自己的得意弟子前往一个叫箱岩的荒岛进行勘探与研究，箱岩的特异的风土人情以及多年前发生的奇异之事，吸引了师徒俩且使他们欲罢不能，先是一对来岛上观光的男女意外横尸野外，事过不久，教授竟溺水身亡，画家也随之东窗事发，年轻主人公陷入了一个难以摆脱的恐怖迷津，这一切到底是如何发生的？一个远离尘嚣的孤岛是一个世外桃源？还是一个惊悚蚀骨的可怕深渊？ ");
        SwiperData m3 = new SwiperData(3,"天机十二宫","王超",localhost+"swiperBooks/tianjishiergong.jpg","http://www.ireader.com/index.php?ca=bookdetail.index&bid=11718735",
                "沈爻怀着不为人知的目的经营上爻堂——为人破案——盛名在外，引来为查明好友之死的陈十六。沈爻性情古怪，为不出山故意戏弄陈十六，却意外发现陈十六身上的秘密；而这个秘密对沈爻目的极有帮助，沈爻以让陈十六为仆做条件才出山……然而，在真相解开后，沈爻为了坚持十二年的目的，忍痛解开陈十六的秘密……与此同时，万筠灵意外发现了沈爻埋藏心里十二年的秘密，她又该作何抉择？");
        List<SwiperData> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        Data<SwiperData> swiperData = new Data<>(200,"ok",list);
//        System.out.println("swiperData: "+swiperData.toString());
        return swiperData;
    }

    //推荐列表
    @RequestMapping(value = "/hot")
    @ResponseBody
    public Data<HotData> getHotData(){
        localhost=getHost()+"images/";
        HotData h1 = new HotData(1,"青玄机","吴沉水",localhost+"swiperBooks/qingxuanji.jpg","www.ireader.com/index.php?ca=bookdetail.index&bid=12189791",
                "他向来晓得这个徒弟与众不同，可没曾想，她是与众不同的傻。她十一岁时，他骗她作饵引怪虫上钩，她说，若是有用，作饵也无妨。她十八岁，他骗她和仇人双修，她说，若是有用，作饵也无妨。如今她二十八岁，他想再骗她最后一次…… 我乃青玄仙子精魂转世，身负五灵之力，天下功法到我手里皆能抽丝剥茧、化繁就简。而你的拙劣谎言，我似乎永远看不穿");
        HotData h2 = new HotData(2,"抑郁森林","飞翼",localhost+"swiperBooks/yiyusenlin.jpg","http://www.ireader.com/index.php?ca=bookdetail.index&bid=11634554",
                "细琐的证据链拼凑出完美的犯罪事实，警官唐纳德的笔记里仍缺失案件的真实动机。玩具公司任职的石骏四年来一帆风顺，随着董事长、画家妻子、案件关联人的相继意外死亡，一条看不清的线将离奇的案子带入谷底。抑郁的内心深处杂草丛生，是一片迷失了灯塔的灰暗森林。犯下完美的罪行，我不相信世间真有奇迹般的本格推理。 ");
        HotData h3 = new HotData(3,"与狼共枕","叶落无心",localhost+"swiperBooks/yulanggongzen.jpg","http://www.ireader.com/index.php?ca=bookdetail.index&bid=12189798",
                "“韩小姐，有位先生说酒会结束后想请您吃夜宵。” 她冷冷扫了一眼支票：“请转告他，我没……” 她的眼睛蓦地被支票上面的字迹灼痛。当然，灼痛她的不是纸上数不清的零，而是那刚劲飞扬的签名——韩濯晨。 只是这三个字而已，就令她心头层层叠叠的茧七零八落，支离破碎。 这一瞬间，理智让她快点逃走，千万不要看他一眼，一眼都不行。可她还是不受控制地环顾四周，仓皇地搜索着记忆中的身影。 十二年前。 韩芊芜一直都相信，她被韩濯晨收养是天意，天意让她潜伏在杀父仇人的身边，天意又让她爱上了他。 那时，她的全家被杀，他是“罪魁祸首”，他不知道她的身份，将她阴错阳差地留在了身边。 这世上最可怕的男人，唯独对她软声细语：“你是我的，你心里只能想着我。” 再见他时，所有爱意化为恨，她用周围人都能听见的声音对他说：“我好想你啊……干爹。” 他的肌肉骤然一僵。 她的笑意更灿烂，准备放开拥着他的手，看看周围人震惊到什么程度。 他却忽然伸出双手，紧紧搂住她的腰，将她固定在怀抱里：“我也想你，韩太太。”");
        HotData h4 = new HotData(4,"福尔摩斯探案集","(英)柯南·道尔",localhost+"swiperBooks/Sherlock.jpg","http://www.abxsb.com/book/272332/",
                "长期以来，一位名叫歇洛克福尔摩斯的侦探吸引了无数人的眼球，充满画面感的文字，紧张到让人尖叫的故事，让人为之疯狂。在案件中，福尔摩斯细致的观察，抓住蛛丝马迹，顺藤摸瓜，通过自己的逻辑推理，如同身临其境般“看”到罪犯的犯罪现场，同华生医生一起经历了一场又一场惊险无比的探案历程。");
        HotData h5 = new HotData(5,"孤岛疑云","林苑中",localhost+"swiperBooks/gudaoyiyun.jpg","http://www.ireader.com/index.php?ca=bookdetail.index&bid=11050641",
                "一位致力于生物学研究的教授带着自己的得意弟子前往一个叫箱岩的荒岛进行勘探与研究，箱岩的特异的风土人情以及多年前发生的奇异之事，吸引了师徒俩且使他们欲罢不能，先是一对来岛上观光的男女意外横尸野外，事过不久，教授竟溺水身亡，画家也随之东窗事发，年轻主人公陷入了一个难以摆脱的恐怖迷津，这一切到底是如何发生的？一个远离尘嚣的孤岛是一个世外桃源？还是一个惊悚蚀骨的可怕深渊？ ");
        HotData h6 = new HotData(6,"天机十二宫","王超",localhost+"swiperBooks/tianjishiergong.jpg","http://www.ireader.com/index.php?ca=bookdetail.index&bid=11718735",
                "沈爻怀着不为人知的目的经营上爻堂——为人破案——盛名在外，引来为查明好友之死的陈十六。沈爻性情古怪，为不出山故意戏弄陈十六，却意外发现陈十六身上的秘密；而这个秘密对沈爻目的极有帮助，沈爻以让陈十六为仆做条件才出山……然而，在真相解开后，沈爻为了坚持十二年的目的，忍痛解开陈十六的秘密……与此同时，万筠灵意外发现了沈爻埋藏心里十二年的秘密，她又该作何抉择？");
        List<HotData> list = new ArrayList<>();

        int random = (int)(Math.random()*5);
        if(random%2 == 0) {
            list.add(h1);
            list.add(h2);
            list.add(h3);
        }
        else {
            list.add(h4);
            list.add(h5);
            list.add(h6);
        }
        Data<HotData> hotdata = new Data<>(200,"ok",list);
        return hotdata;
    }

    //获取书籍列表
    @RequestMapping(value = "/getlist")
    @ResponseBody
    public Data<Book> getBooksData(Integer page){
        List<Book> allBook=bookService.queryBook();
        Data<Book> data=null;
        List<Book> pageList = null;
        if(page*5<allBook.size()){
            int i;
            pageList=new ArrayList<>();
            for (i= page *5; i<(allBook.size()+4); i++){
                pageList.add(allBook.get(i));
                if((i+1)%5==0){
                    break;
                }
            }
            if ((page+1)*5>=allBook.size()){
                data=new Data<>(200,"last",pageList);
            }else {
                data=new Data<>(200,"ok",pageList);
            }
        }else {
            data=new Data<>(200,"noMore",pageList);
        }
        return data;
    }

    //更新单本收藏
    @RequestMapping("/updateLike")
    @ResponseBody
    public Data updateLike(Integer bookId, String username){
        UserInfo user=userService.getUser(username);
        String likeJson=user.getLikeList();
        Gson gson=new Gson();
        ArrayList<Integer> likeList;
        if (!likeJson.equals("")){
            likeList=gson.fromJson(likeJson,
                    new TypeToken<ArrayList<Integer>>(){}.getType());
        }else {
            likeList=new ArrayList<>();
        }
        String query=queryLike(username,bookId);
        switch (query){
            case "isLike":
                likeList.remove(new Integer(bookId));
                break;
            case "isUnLike":
                likeList.add(bookId);
                break;
            default:
                System.out.println("Error");
        }
        likeJson=gson.toJson(likeList);
        Long result=userService.updateLike(username,likeJson);
        if (result==1){
            System.out.println("更新成功");
            switch (query){
                case "isLike":
                    return new Data(200,"dislike");
                case "isUnLike":
                    return new Data(200,"like");
                default:
                    System.out.println("Error");
            }
        }else {
            System.out.println("失败");
        }
        return new Data(200,"error");
    }

    //查询是否收藏
    @RequestMapping("/queryLike")
    @ResponseBody
    public String queryLike(String username,Integer bookId){
        UserInfo user=userService.getUser(username);
        String likeJson=user.getLikeList();

        if (!likeJson.equals("")){
            Gson gson=new Gson();
            ArrayList<Integer> likeList=gson.fromJson(likeJson,
                    new TypeToken<ArrayList<Integer>>(){}.getType());
            for(int i : likeList){
                if(i==bookId){
                    return "isLike";
                }
            }
        }
        return "isUnLike";
    }

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    private Data<UserInfo> login(String name, String pw){
        UserInfo user= userService.login(name,pw);
        Data<UserInfo> result=null;
        if (user!=null){
            result=new Data<UserInfo>(200,"ok",user);
        }else {
            result=new Data<UserInfo>(200,"false",user);
        }
        return result;
    }

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    @ResponseBody
    private Data<UserInfo> register(String name, String pw){
        UserInfo user=userService.getUser(name);
        Data<UserInfo> result=null;
        if (user==null){
            userService.register(name,pw);
            user=userService.getUser(name);
            if (user!=null){
                result=new Data<UserInfo>(200,"ok",user);
            }else {
                result=new Data<UserInfo>(200,"false",user);
            }
        }else {
            result=new Data<UserInfo>(200,"isExist",user);
        }
        return result;
    }

    //上传头像
    @RequestMapping("/upload")
    @ResponseBody
    public Data<UserInfo> upload(String username, MultipartFile file,
                                 HttpServletRequest request) throws Exception{
        Data<UserInfo> result=null;
        UserInfo user= userService.getUser(username);
        localhost=getHost()+"images/";
        if (user!=null) {
            String uploadPath= request.getServletContext().getRealPath("/images/headImg");
            File dir=new File(uploadPath);
            if (!dir.exists()){
                dir.mkdirs();//创建文件夹
            }
            String originalFileName=file.getOriginalFilename();
            String suffix=originalFileName.split("\\.")[1];//后缀名  \\.(转义字符)--'.'
            String userId="userId-"+user.getId();
            String newFileName=userId+"."+suffix;
            file.transferTo(new File(uploadPath+ File.separator+newFileName));
            Long i = userService.update(username, localhost+"/headImg/" + newFileName);
            if (i == 1) {
                user = userService.getUser(username);
                result = new Data<UserInfo>(200, "ok", user);
            } else {
                result = new Data<UserInfo>(200, "false", user);
            }
        }
        return result;
    }

    //查找书籍
    public List<Book> queryBooks(ArrayList<Integer> likeList){
        List<Book> qBook=new ArrayList<Book>();
        for (int i : likeList){
            qBook.add(bookService.queryLikeBook(i));
        }
        return qBook;
    }

    //收藏列表
    @RequestMapping("/collections")
    @ResponseBody
    public Data<Book> collections(String username){
        UserInfo user=userService.getUser(username);
        List<Book> list=new ArrayList<>();
        String likeJson=user.getLikeList();

        if (!likeJson.equals("")){
            Gson gson=new Gson();
            ArrayList<Integer> likeList=gson.fromJson(likeJson,
                    new TypeToken<ArrayList<Integer>>(){}.getType());
            list=queryBooks(likeList);
            return new Data<>(200,"get",list);
        }
        return new Data<>(200,"no",list);
    }
}

/*
* Book b1 = new Book(1,"写过爱过活过",localhost+"booksImg/写过爱过活过.jpg",
                "社会学家李银河新版自传——一位女性主义者的人生自述，坦荡、独立、勇敢、自由，一生所求不过爱与美。生于1950年代，经历“文革”、上山下乡、工农兵学员、公派留学……李银河成长中的苦闷彷徨和命运转折，带有鲜明的时代烙印，是那一代知识分子从理想狂热走向独立思考，再到致力于社会进步的缩影。成长、爱情、学术在李银河生命中占据着重要的位置。在人生的这三个向度上，她“像蜜蜂采蜜一样”，只采撷最精华的部分。");
        Book b2 = new Book(2,"平凡的世界",localhost+"booksImg/平凡的世界.jpg",
                "一部现实主义小说，也是一部小说形式的家族史。作者浓缩了中国西北农村的历史变迁过程，在小说中全景式地表现了中国当代城乡的社会生活。在近十年的广阔背景下，通过复杂的矛盾纠葛，刻划社会各阶层众多普通人的形象。劳动与爱情，挫折与追求，痛苦与欢乐，日常生活与巨大社会冲突，纷繁地交织在一起，深刻地展示了普通人在大时代历史进程中所走过的艰难曲折的道路。");
        Book b3 = new Book(3,"骆驼祥子",localhost+"booksImg/骆驼祥子.jpg",
                "老舍用同情的笔触描绘的一幕悲剧：二十年代的北京，一个勤劳、壮实的底层社会小人物怀着发家、奋斗的美好梦想，却最终为黑暗的暴风雨所吞噬。它揭示了当时“小人物”的奴隶心理和希望的最终破灭。随着祥子心爱的女人小福子的自杀，祥子熄灭了个人奋斗的最后一朵火花。这是旧中国老北京贫苦市民的典型命运。");
        Book b4 = new Book(4,"朱一龙写真集",localhost+"booksImg/朱一龙写真集.jpg",
                "该本写真集拍摄于澳大利亚悉尼，在新州旅游局支持下，顺利于悉尼歌剧院、海港大桥、皇家植物园、帕丁顿水库、史蒂芬港、La Perouse港湾、悉尼情人港等11地取景。首本写真集对朱一龙而言是一次全新的体验与尝试，全集收录150多张高清大图，通过摄影师的镜头记录，真实的展露了其在这段旅程中的不同状态。");
        Book b5 = new Book(5,"活着",localhost+"booksImg/活着.jpg",
                "讲述了农村人福贵悲惨的人生遭遇。福贵本是个阔少爷，可他嗜赌如命，终于赌光了家业，一贫如洗。他的父亲被他活活气死，母亲则在穷困中患了重病，福贵前去求药，却在途中被国民党抓去当壮丁。经过几番波折回到家里，才知道母亲早已去世，妻子家珍含辛茹苦地养大两个儿女。此后更加悲惨的命运一次又一次降临到福贵身上，他的妻子、儿女和孙子相继死去，最后只剩福贵和一头老牛相依为命，但老人依旧活着，仿佛比往日更加洒脱与坚强。");
        Book b6 = new Book(6,"撒野",localhost+"booksImg/撒野.jpg",
                "我想，左肩有你，右肩微笑。我想，在你眼里，撒野奔跑，我想，一个眼神，就到老。");
        Book b7 = new Book(7,"从你的全世界路过",localhost+"booksImg/从你的全世界路过.jpg",
                "最初以“睡前故事”系列的名义在网上疯狂流传，几天内达到1,500,000 次转发，超4亿次阅读，引来电影投资方的巨资抢购，转瞬便签下其中5个故事的电影版权。每1分钟，都有人在张嘉佳的故事里看到自己。");
        Book b8 = new Book(8,"梦里花落知多少",localhost+"booksImg/梦里花落知多少.jpg",
                "郭敬明出版的第二部小说，此作一改《幻城》的奇幻风格，从天上回到人间。小说以北京、上海等大都市为背景，讲述了几个年青人的爱情故事，情节曲折，语言幽默生动。主人公是一些即将走出校门的大学生，在成长的过程中，友情、爱情都在经历着蜕变，那种成长的快乐和忧伤很能引起年轻读者的共鸣。");
        Book b9 = new Book(9,"无羁",localhost+"booksImg/无羁.jpg",
                "夷陵老祖魏无羡，前世受万人唾骂，声名狼藉。被情同手足的师弟带人端了老巢，纵横一世，死无全尸。十三年后，被人以禁术强行召回世上，竟沦为一名受尽欺压折辱的疯人，卷入一桩诡异的五马分尸奇案！在曾与自己\"水火不容\"的仙门名士蓝忘机结伴同行的路上，往事风云再起。");
        Book b10 = new Book(10,"一个人的好天气",localhost+"booksImg/一个人的好天气.jpg",
                "一个打零工的女孩如何与年长亲人相处，同时追寻自我、独立的故事，走向自立的一名女孩在工作、生活和恋爱中的种种际遇和心情令人揪心，小说写尽了做一名自由职业者（“飞特族”）的辛酸。内容折射出当前日本的一个社会问题，即许多年轻人不愿投入全职工作而四处打工，宁愿做自由职业者，他们不想长大，不愿担负责任，无法独立，害怕走出去看看这个世界，但是又不知道这种恐惧从何而来。");
        List<Book> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        list.add(b6);
        list.add(b7);
        list.add(b8);
        list.add(b9);
        list.add(b10);
* */
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
