  <template>
 	<view class="center mainContainer">
 		<view class="logo" @click="!login ? goLogin() : account()" :hover-class="!login ? 'logo-hover' : ''">
			<view v-if="login">
				<image class="logo-img" :src="userInfo.imgUrl" mode="aspectFill"></image>
			</view>
 			<view v-else>
				<image class="logo-img" src="../../static/img/face.png" mode="aspectFill"></image>
			</view>
			<view class="logo-title">
 				<text class="uer-name">{{login ? 'Hi, '+userInfo.userName : '您未登录'}}</text>
 				<text class="go-login navigat-arrow iconfont" v-if="!login">&#xe743;</text>
 			</view>
 		</view>
 		<view class="center-list">
 			<view class="center-list-item border-bottom" @click="account">
				<image class="list-icon" src="../../static/img/read.png"></image>
 				<text class="list-text">帐号管理</text>
 				<text class="navigat-arrow iconfont">&#xe743;</text>
 			</view>
 			<view class="center-list-item" @click="collect">
				<image class="list-icon" src="../../static/img/collection.png"></image>
 				<text class="list-text">收藏</text>
 				<text class="navigat-arrow iconfont">&#xe743;</text>
 			</view>
 		</view>
 	</view>
 </template>
 
 <script>
 	export default {
 		data() {
 			return {
 				login: false,
 				userInfo: {}
 			}
 		},
		onLoad(){
			console.log("mine page load")
		},
 		onShow() {
			var u=uni.getStorageSync("user");
 			console.log("MyPage");
			if(u!=null&&u!={}){
				this.userInfo=u;
				this.login=true;
			}else{
				this.userInfo={};
				this.login=false;
			}
 		},
 		methods: {
 			goLogin() {
 				if (!this.login) {
 					// 跳转到login页面
					uni.navigateTo({
						url:"login/login"
					});
 				}
 			},
 			account(){
 				if (!this.login) {
					uni.navigateTo({
						url:"login/login"
					});
 				}else{
					uni.navigateTo({
						url:"account/account"
					});
 				}
 			},
 			collect(){
 				if (!this.login) {
					uni.navigateTo({
						url:"login/login"
					});
 				}else{
 					uni.navigateTo({
 						url:"../collection/collection"
 					});
 					console.log("收藏夹");
 				}
 			}
 		}
 	}
 </script>
 
 <style>
 	@import url("mine.css");
 </style>
 