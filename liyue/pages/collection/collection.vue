<template>
	<view class="mainContainer">
		<view class="c-list">
			<view class="single-book" v-for="(Citem,Bookid) in likeList" :key="Citem.bookId" @click="goBook(Bookid)">
				<image class="c-image" :src="Citem.imgUrl" mode="aspectFit"></image>
				<view class="c-name">{{Citem.bookName}}</view>
				<view class="bg"></view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				likeList:[]
			}
		},
		onLoad() {
		},
		onShow() {
			var u=uni.getStorageSync("user");
			uni.request({
				url:this.serverUrl+'collections?username='+u.userName,
				success:(res)=> {
					console.log(res.data.data)
					if(res.statusCode==200){
						if(res.data.statusCode == 200){
							if(res.data.msg == "get"){
								console.log("get");
								this.likeList = res.data.data;
								console.log("list : "+this.likeList);
							}
						}
					}
				},
				fail(){
					console.log("False!");
				}
			});
		},
		methods: {
			goBook(id){
				console.log(id);
				uni.setStorageSync("book",this.likeList[id]);
				uni.navigateTo({
					url:"../bookInfo/bookInfo"
				});
			}
		}
	}
</script>

<style>
	@import url("collection.css");
</style>
