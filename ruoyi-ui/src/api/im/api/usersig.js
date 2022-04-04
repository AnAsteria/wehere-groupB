export function getUserSig(userId) {
  return request({
    url: `/im/usersig/${userId}`,
    method: 'get',
  })
}
