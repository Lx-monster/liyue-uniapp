<template>
	<view>
		<web-view :src="url"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				url:''
			}
		},
		onLoad() {
			this.url=uni.getStorageSync("url");
		},
		onBackPress(){
			uni.setStorageSync("url",'');
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
