import Vue from 'vue'
import App from './App'
import iconfont from '@/assets/iconfont/iconfont.css'

Vue.config.productionTip = false
Vue.prototype.serverUrl="http://localhost:8087/s/"

App.mpType = 'app'

const app = new Vue({
    ...App
})
app.$mount()
