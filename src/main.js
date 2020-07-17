import Vue from 'vue'
import Vuex from 'vuex'
import router from 'vue-router'
import axios from 'axios'
import App from './App.vue'

axios.defaults.baseURL = 'http://localhost:8080/'

Vue.config.productionTip = false

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')