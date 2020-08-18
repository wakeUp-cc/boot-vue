import { Notification } from 'element-ui'

export default {
  spring (result) {
    let message = result.message
    if (result.status === 0) {
      Notification.error({
        title: '错误',
        message: message,
        position: 'bottom-right'
      })
    } else if (result.status === 1) {
      Notification({
        title: '提示',
        message: message,
        position: 'bottom-right'
      })
    }
  }
}
