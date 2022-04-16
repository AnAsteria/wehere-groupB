import request from '@/utils/request'

// 查询排班表管理列表
export function listSchedule(query) {
  return request({
    url: '/system/schedule/list',
    method: 'get',
    params: query
  })
}

// 最高权限查询排班表管理列表
export function suListSchedule(query) {
  return request({
    url: '/system/schedule/su_list',
    method: 'get',
    params: query
  })
}

// 查询排班表管理详细
export function getSchedule(id) {
  return request({
    url: '/system/schedule/' + id,
    method: 'get'
  })
}

// 新增排班表管理
export function addSchedule(data) {
  return request({
    url: '/system/schedule',
    method: 'post',
    data: data
  })
}

// 修改排班表管理
export function updateSchedule(data) {
  return request({
    url: '/system/schedule',
    method: 'put',
    data: data
  })
}

// 删除排班表管理
export function delSchedule(id) {
  return request({
    url: '/system/schedule/' + id,
    method: 'delete'
  })
}
