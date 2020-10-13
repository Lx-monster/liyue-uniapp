<template>
	<view class="mainContainer">
		<form @submit="login">
			<view class="loginContainer">
				<!-- input名字要和服务器login方法的参数名相同 -->
				<input class="input border" name="name" v-model="user" placeholder="用户名" type="text" maxlength="10" />
				<input class="input border" name="pw" v-model="password" placeholder="密码" type="password" />
				<button class="button border" type="primary" form-type="submit">登录</button>
			</view>
		</form>
		<view class="footer">
			<navigator url="register/register" open-type="navigate">注册账号</navigator>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				avatarUrl: "",
				user:'',
				password:'',
				userInfo: []
			}
		},
		onLoad() {
			console.log("登录");
			// this.login();
		},
		methods: {
			login(e){
				if(this.user==null||this.user==''){
					uni.showToast({
						icon:"none",
						position: 'bottom',
						title:"用户名不能为空"
					});
					return;
				}
				if(this.password==null||this.password==''){
					uni.showToast({
						icon:"none",
						position: 'bottom',
						title:"密码不能为空"
					});
					return;
				}
				console.log("开始效验");
				uni.request({
					url:this.serverUrl+"login",
					data:e.detail.value,
					success:(res)=>{
						console.log(res)
						if(res.statusCode==200){
							if(res.data.statusCode==200){//停止
								if(res.data.msg=="ok"){
									console.log("login...");
									uni.setStorageSync("user",res.data.userInfo);
									// console.log(res.data.userInfo);
									uni.switchTab({
										url:"../mine"
									});
								}else if(res.data.msg=="false"){
									uni.showToast({
										icon:"none",
										position: 'bottom',
										title:"用户名和密码不匹配"
									});
								}
							}else{
								console.log("false!!!");
							}
						}else{
							console.log("Error!!!");
						}
					},
					fail:()=>{
						console.log("false");
					}
				});
	 		}
		}
	}
</script>

<style>
	@import url("login.css");
</style>
