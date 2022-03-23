import request from '@/utils/request'

// 查询关系管理列表
export function listRelationship(query) {
  return request({
    url: '/system/relationship/list',
    method: 'get',
    params: query
  })
}

// 查询关系管理详细
export function getRelationship(id) {
  return request({
    url: '/system/relationship/' + id,
    method: 'get'
  })
}

// 新增关系管理
export function addRelationship(data) {
  return request({
    url: '/system/relationship',
    method: 'post',
    data: data
  })
}

// 修改关系管理
export function updateRelationship(data) {
  return request({
    url: '/system/relationship',
    method: 'put',
    data: data
  })
}

// 删除关系管理
export function delRelationship(id) {
  return request({
    url: '/system/relationship/' + id,
    method: 'delete'
  })
}
