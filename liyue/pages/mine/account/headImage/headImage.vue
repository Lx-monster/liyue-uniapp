<template>
	<view class="mainContainer">
		<view class="img-container">
			<image :src="imgpath" mode="aspectFit"></image>
		</view>
		<view class="cancelImage-container">
			<image @click="back" class="cancelImage" src="../../../../static/img/cancel.png"></image>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				imgpath:''
			}
		},
		onLoad(path) {
			this.imgpath=path.path;
		},
		methods: {
			back(){
				uni.navigateBack({
					delta:1
				})
			}
		}
	}
</script>

<style>
	@import url("headImage.css");
</style>
