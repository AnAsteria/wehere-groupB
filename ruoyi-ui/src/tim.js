import TIM from 'tim-js-sdk/tim-js-friendship.js'
import TIMUploadPlugin from 'tim-upload-plugin'
import genTestUserSig from './utils/GenerateTestUserSig'

// 初始化 SDK 实例

const tim = TIM.create({
  SDKAppID: genTestUserSig('').SDKAppID
})

window.setLogLevel = tim.setLogLevel

// 无日志级别
tim.setLogLevel(4)

// 注册 cos
tim.registerPlugin({ 'tim-upload-plugin':TIMUploadPlugin })
export default tim
