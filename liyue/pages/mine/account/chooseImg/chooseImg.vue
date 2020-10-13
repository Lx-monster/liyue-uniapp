<template>
	<view class="mainContainer">
		<view class="img-container">
			<image :src="imgpath" mode="aspectFit"></image>
		</view>
		<view class="footer">
			<view @click="rechoose" class="button">重选</view>
			<view @click="upload" class="button">上传</view>
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
			this.imgpath=path.tempFilePath;
		},
		methods: {
			rechoose(){
				console.log("RechangeImage");
				uni.chooseImage({
					count:1,
					sizeType:["compressed"],
					sourceType:["album"],
					success:(res)=>{
						//使用箭头函数,改变作用域范围(广域)
						this.imgpath=res.tempFilePaths[0];
					}
				})
			},
			upload(){
				console.log("upload Image");
				var userInfo=uni.getStorageSync("user");
				uni.uploadFile({
					url:this.serverUrl+"upload?username="+userInfo.userName,
					filePath:this.imgpath,
					name:"file",
					success:(res) => {
						console.log("upload...");
						console.log(res.data);
						var result=JSON.parse(res.data);
						if(result.statusCode==200){
							switch(result.msg){
								case "ok":
									uni.showToast({
										icon:"none",
										position: 'bottom',
										title:"上传成功"
									});
									uni.setStorageSync("user",result.userInfo);
									uni.navigateBack({
										delta:1
									});
									break;
								case "false":
									uni.showToast({
										icon:"none",
										position: 'bottom',
										title:"上传失败"
									});
									break;
								default:
									uni.showToast({
										icon:"none",
										position: 'bottom',
										title:"Error"
									});
							}
						}
					}
				})
			}
		}
	}
</script>

<style>
	@import url("chooseImg.css");
</style>
