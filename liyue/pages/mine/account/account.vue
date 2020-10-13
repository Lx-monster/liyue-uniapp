<template>
	<view class="mainContainer">
		<view class="userInfo-list">
			<view class="item">
				<view class="text">用户ID</view>
				<view class="info">
					<text>{{userInfo.id}}</text>
				</view>
			</view>
			<view>
				
				<view class="item">
					<view class="text">头像</view>
					<view class="info">
						<view @click="changeImg" class="head" hover-class="head-hover"></view>
						<image @click="headImage" class="userImg" :src="userInfo.imgUrl" mode="aspectFill"></image>
					</view>
					<text class="navigat-arrow iconfont">&#xe743;</text>
				</view>
			</view>
			<view class="item">
				<view class="text">用户名</view>
				<view class="info">
					<text>{{userInfo.userName}}</text>
				</view>
			</view>
			<view @click="logout" class="btncontainer btnbanner" hover-class="btn-hover"></view>
			<view class="btncontainer btnItem">
				<button class="btn">退出登录</button>
			</view>
			
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				userInfo: {}
			}
		},
		onShow(){
			console.log("账户管理");
			this.userInfo=uni.getStorageSync("user");
		},
		onBackPress(e){
			uni.reLaunch({
				url: "../mine"
			})
		},
		methods: {
			//登出
			logout(){
				uni.showModal({
					content: '是否要退出登录',
					success(res){
						if(res.confirm){
							console.log("退出登录");
							uni.setStorageSync("user",null);
							uni.switchTab({
								url: "../mine"
							});
						}else if(res.cancel){
							console.log("取消");
						}
					}
				})
			},
			changeImg(){//更换头像
				uni.showActionSheet({
					itemList:["选择头像"],
					success:(res)=> {
						if(res.tapIndex==0){
							console.log("changeImage");
							uni.chooseImage({
								count:1,
								sizeType:["compressed"],
								sourceType:["album"],
								success:(res)=> {
									var tempFilePath=res.tempFilePaths[0];
									uni.navigateTo({
										url:"chooseImg/chooseImg?tempFilePath="+tempFilePath
									})
								}
							})
						}
					}
				})
			},
			headImage(){
				uni.navigateTo({
					url:"headImage/headImage?path="+this.userInfo.imgUrl
				})
			}
		}
	}
</script>

<style>
	@import url("account.css");
</style>
