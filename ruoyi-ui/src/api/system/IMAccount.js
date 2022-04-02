import request from '@/utils/request'

// 查询IMAccount管理列表
export function listIMAccount(query) {
  return request({
    url: '/system/IMAccount/list',
    method: 'get',
    params: query
  })
}

// 查询IMAccount管理详细
export function getIMAccount(id) {
  return request({
    url: '/system/IMAccount/' + id,
    method: 'get'
  })
}

// 新增IMAccount管理
export function addIMAccount(data) {
  return request({
    url: '/system/IMAccount',
    method: 'post',
    data: data
  })
}

// 修改IMAccount管理
export function updateIMAccount(data) {
  return request({
    url: '/system/IMAccount',
    method: 'put',
    data: data
  })
}

// 删除IMAccount管理
export function delIMAccount(id) {
  return request({
    url: '/system/IMAccount/' + id,
    method: 'delete'
  })
}
