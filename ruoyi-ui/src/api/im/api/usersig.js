import request from '@/utils/request'

export function getUserSig(userId) {
  return request({
    url: `/im/usersig/${userId}`,
    method: 'get',
  })
}

export const SDKAppID = 1400637187;