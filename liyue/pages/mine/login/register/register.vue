<template>
	<view class="mainContainer">
		<form @submit="register">
			<view class="registerContainer">
				<input class="input border" name="name" v-model="user" placeholder="用户名(注册后不可修改)" type="text" maxlength="10" />
				<input class="input border" name="pw" v-model="password" placeholder="密码(不少于6位)" type="password" />
				<input class="input border" name="checkpw" v-model="checkpw" placeholder="确认密码" type="password" />
				<button class="button border" type="primary" form-type="submit">注册</button>
			</view>
		</form>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:'',
				password:'',
				checkpw:'',
				userInfo: []
			}
		},
		methods: {
			register(e){
				if(this.user==null){
					uni.showToast({
						icon:"none",
						position: 'bottom',
						title:"用户名不能为空"
					});
					return;
				}
				if(this.password==null||this.password.length<6){
					uni.showToast({
						icon:"none",
						position: 'bottom',
						title:"密码过短, 请重新设置"
					});
					return;
				}
				if(this.checkpw!==null&&this.checkpw===this.password){
					uni.request({
						url:this.serverUrl+"register",
						data:e.detail.value,
						success:(res)=>{
							if(res.statusCode==200){
								if(res.data.statusCode==200){
									if(res.data.msg=="ok"){
										uni.setStorageSync("user",res.data.userInfo);
										// console.log(res.data.userInfo);
										// console.log("注册成功");
										uni.showToast({
											icon:"none",
											position: 'bottom',
											title:"注册成功"
										});
										uni.switchTab({
											url:"../../mine"
										});
									}else if(res.data.msg=="isExist"){
										uni.showToast({
											icon:"none",
											position: 'bottom',
											title:"用户已存在"
										});
									}else if(res.data.msg=="false"){
										uni.showToast({
											icon:"none",
											position: 'bottom',
											title:"注册未成功"
										});
									}
								}
							}
						},
						fail:()=>{
							console.log("false");
						}
					});
				}else{
					uni.showToast({
						icon:"none",
						position: 'bottom',
						title:"密码不一致"
					});
				}
			}
		}
	}
</script>

<style>
	@import url("register.css");
</style>
