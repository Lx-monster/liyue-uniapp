<template>
	<view class="content mainContainer">
		<view class="swiper-container">
			<!-- 轮播图 -->
			<swiper class="swiper" :autoplay="true" :indicator-dots="true" :interval="3000" :duration="500" indicator-active-color="#F5F5F5">
				<swiper-item v-for="(item,i) in swiperData" :key="item.swiperId" class="swiper-item" @click="goBooks('swiper',i)">
					<image class="swiper-image" :src="item.imageUrl" mode="aspectFit"></image>
					<view class="sImg-info">
						<view class="sImg-info-bg"></view>
						<text>{{item.swiperName}}</text>
					</view>
				</swiper-item>
			</swiper>
		</view>
	
		<view class="books-container">
			<!-- 精选书籍 -->
			<view class="title">
				<text class="title-info">推荐</text>
			</view>
			<view class="special-list">
				<view class="single-book" v-for="(hotItem,hotId) in hotData" :key="hotItem.hotId" @click="goBooks('hot',hotId)">
					<image class="hotbook-image" :src="hotItem.imageUrl" mode="aspectFit"></image>
					<view class="hotbook-name">{{hotItem.booksName}}</view>
				</view>
			</view>
			<!-- 书籍列表 -->
			<view class="title">
				<text class="title-info">精选</text>
			</view>
			<view class="booksList">
				<view class="book" v-for="(book,bookId) in booksData" :key="book.bookId" @click="goBooks('list',bookId)">
					<image class="book-image" :src="book.imgUrl" mode="aspectFit"></image>
					<view class="book-des">
						<view class="book-title">{{book.bookName}}</view>
						<view class="book-info">{{book.bookInfo}}</view>
						<view class="separ"></view>
					</view>
				</view>
				<view class="list-footer">
					<text>到底啦</text>
				</view>
			</view>
		</view>
	</view>
	
</template>

<script>
	export default {
		data() {
			return {
				swiperData:[],
				hotData:[],
				booksData:[],
				page:0,
				pageTotal:999
			}
		},
		onLoad() {
			this.getDatas("swiper",this.swiperData);
			this.getDatas("hot",this.hotData);
			this.page=0;
			this.loadList();
		},
		onShow() {
			
		},
		onPullDownRefresh(){
			//下拉刷新
			this.getDatas("hot",this.hotData);
			uni.stopPullDownRefresh();
		},
		onReachBottom() {
			//底部上拉加载
			if(this.page<this.pageTotal){
				this.loadList();
			}else{
				uni.showToast({
					icon:"none",
					position: 'bottom',
					title:"没啦"
				});
			}
			
		},
		methods: {
			getDatas(url,datas){
				uni.request({
					url:this.serverUrl+url,
					success(res) {
						if(res.statusCode==200){
							if(res.data.statusCode == 200){
								datas.length = 0;
								if(res.data.msg == "ok"){
									var list = [];
									list = res.data.data;
									for(let i=0;i<list.length;i++){
									     datas.push(list[i]);
										 // console.log("list "+i+" : "+list[i].swiperId);
									}
								}
							}
						}
					},
					fail(){
						console.log("False!");
					}
				})
			},
			goBooks(str,id){
				console.log(str+" : "+id);
				switch(str){
					case "swiper":
						var sendSwiperbook={
							fromS:'s',
							bookName:this.swiperData[id].swiperName,
							author:this.swiperData[id].author,
							imgUrl:this.swiperData[id].imageUrl,
							bookInfo:this.swiperData[id].swiperInfo,
							bookUrl:this.swiperData[id].bookUrl
						}
						uni.setStorageSync("book",sendSwiperbook);
						uni.navigateTo({
							url:"../bookInfo/bookInfo"
						});
						break;
					case "hot":
						var sendHotbook={
							fromS:'h',
							bookName:this.hotData[id].booksName,
							author:this.hotData[id].author,
							imgUrl:this.hotData[id].imageUrl,
							bookInfo:this.hotData[id].bookInfo,
							bookUrl:this.hotData[id].bookUrl
						}
						uni.setStorageSync("book",sendHotbook);
						uni.navigateTo({
							url:"../bookInfo/bookInfo"
						});
						break;
					case "list":
						uni.setStorageSync("book",this.booksData[id]);
						uni.navigateTo({
							url:"../bookInfo/bookInfo"
						});
						break;
					default:
						uni.showToast({
							icon:"none",
							position: 'bottom',
							title:"error"
						});
				}
			},
			loadList(){
				uni.showLoading({
					title:"加载中..."
				});
				uni.request({
					url:this.serverUrl+"getlist?page="+this.page,
					success:(res)=> {
						if(res.statusCode==200){
							if(res.data.statusCode==200){
								if(res.data.msg=='ok'){
									var pagelist = [];
									pagelist = res.data.data;
									this.booksData=this.booksData.concat(pagelist);
									this.page++;
									console.log(this.page);
								}else if(res.data.msg=='last'){
									this.pageTotal=this.page+1;
									console.log("this.pageTotal : "+this.pageTotal);
									var pagelist = [];
									pagelist = res.data.data;
									this.booksData=this.booksData.concat(pagelist);
									this.page++;
								}else{
									uni.showToast({
										icon:"none",
										position: 'bottom',
										title:"出问题了"
									});
								}
							}
						}else{
							console.log("失败2222222")
						}
					},
					fail() {
						console.log("失败11111111")
					},
					complete() {
						uni.hideLoading();
					}
				});
			}
		}
	}
</script>

<style>
	@import url("index.css");
</style>
