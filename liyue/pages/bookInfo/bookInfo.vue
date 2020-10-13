<template>
	<view class="mainContainer">
		<view class="book-single">
			<image :src="book.imgUrl" class="book-image" mode="aspectFit"></image>
			<view class="book-desc">
				<view class="book-title">{{book.bookName}}</view>
				<view class="book-text">作者：{{book.author}}</view>
				<view class="book-text">
					<view class="book-like" v-if="book.fromS=='l'">
						<view class="like-text">收藏</view>
						<view class="like iconfont" :class="changeIcon" @click="change"></view>
					</view>
				</view>
				<view class="book-text">链接：<text class="link" @click="go">点击前往</text></view>
			</view>
		</view>
		<view class="separator"></view>
		<!-- 书本介绍 -->
		<view class="introduce">
				<view class="Infotitle">内容简介</view>
				<text class="info">{{book.bookInfo}}</text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				book:{},
				user:{},
				changeIcon:'iconfollow'
			}
		},
		onLoad() {
			this.book=uni.getStorageSync("book");
			this.user=uni.getStorageSync("user");
			if(this.book.fromS=='l'){
				this.loadLike();
			}
		},
		methods: {
			loadLike(){
				// 判断是否被收藏
				if(this.user!=''&&this.user!=null){
					uni.request({
						url:this.serverUrl+"queryLike?username="+this.user.userName+"&bookId="+this.book.bookId,
						success:(res)=> {
							if(res.statusCode==200){
								if(res.data=='isLike'){
									this.changeIcon='iconunfollow';
								}else if(res.data=='isUnLike'){
									this.changeIcon='iconfollow';
								}
							}else{
								console.log("Error!!!");
							}
						}
					})
				}else{
					return;
				}
			},
			go(){
				uni.setStorageSync("url",this.book.bookUrl)
				uni.navigateTo({
					url:"web-view/web-view"
				});
			},
			change(){
				if(this.user!=''&&this.user!=null){
					uni.request({
						url:this.serverUrl+"updateLike?username="+this.user.userName+"&bookId="+this.book.bookId,
						success:(res)=> {
							if(res.statusCode==200){
								if(res.data.statusCode==200){
									if(res.data.msg=="like"){
										this.changeIcon='iconunfollow';
										uni.showToast({
											icon:"none",
											position:"bottom",
											title:"收藏成功"
										});
									}else if(res.data.msg=="dislike"){
										this.changeIcon='iconfollow';
										uni.showToast({
											icon:"none",
											position: 'bottom',
											title:"取消收藏"
										});
									}else{
										uni.showToast({
											icon:"none",
											position: 'bottom',
											title:"失败"
										});
									}
								}else{
									console.log("false!!!");
								}
							}else{
								console.log("Error!!!");
							}
						},
						fail() {
							console.log("request fail********");
						}
					})
				}else{
					uni.showToast({
						icon:"none",
						position:"bottom",
						title:"请登录"
					});
				}
			}
		}
	}
</script>

<style>
	@import url("bookInfo.css");
</style>
