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

const store = new Vuex.Store({
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
  getters
})

export default store
