import Vue from 'vue'
import Vuex from 'vuex'
import app from './modules/app'
import user from './modules/user'
import tagsView from './modules/tagsView'
import permission from './modules/permission'
import settings from './modules/settings'
import blacklist from './modules/blacklist'
import conversation from './modules/conversation'
import friend from './modules/friend'
import group from './modules/group'
import groupLive from './modules/groupLive'
import video from './modules/video'
import getters from './getters'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    current: Date.now(), // 当前时间
    intervalID: 0,
    message: undefined
  },
  mutations: {
    startComputeCurrent(state) {
      state.intervalID = setInterval(() => {
        state.current = Date.now()
      }, 500)
    },
    stopComputeCurrent(state) {
      clearInterval(state.intervalID)
      state.intervalID = 0
    },
    showMessage(state, options) {
      if (state.message) {
        state.message.close()
      }
      state.message = Message({
        message: options.message,
        type: options.type || 'success',
        duration: options.duration || 2000,
        offset: 40
      })
    }
  },
  modules: {
    app,
    user,
    tagsView,
    permission,
    settings,
    blacklist,
    conversation,
    friend,
    group,
    groupLive,
    video,
  },
  getters,
})
