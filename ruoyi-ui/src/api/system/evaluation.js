import request from '@/utils/request'

// 查询评价系统列表
export function listEvaluation(query) {
  return request({
    url: '/system/evaluation/list',
    method: 'get',
    params: query
  })
}

// 查询评价系统详细
export function getEvaluation(id) {
  return request({
    url: '/system/evaluation/' + id,
    method: 'get'
  })
}

// 新增评价系统
export function addEvaluation(data) {
  return request({
    url: '/system/evaluation',
    method: 'post',
    data: data
  })
}

// 修改评价系统
export function updateEvaluation(data) {
  return request({
    url: '/system/evaluation',
    method: 'put',
    data: data
  })
}

// 删除评价系统
export function delEvaluation(id) {
  return request({
    url: '/system/evaluation/' + id,
    method: 'delete'
  })
}
