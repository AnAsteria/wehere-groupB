import request from '@/utils/request'

// 查询咨询师-督导关系管理列表
export function listConsultant-supervisor(query) {
  return request({
    url: '/system/consultant-supervisor/list',
    method: 'get',
    params: query
  })
}

// 查询咨询师-督导关系管理详细
export function getConsultant-supervisor(id) {
  return request({
    url: '/system/consultant-supervisor/' + id,
    method: 'get'
  })
}

// 新增咨询师-督导关系管理
export function addConsultant-supervisor(data) {
  return request({
    url: '/system/consultant-supervisor',
    method: 'post',
    data: data
  })
}

// 修改咨询师-督导关系管理
export function updateConsultant-supervisor(data) {
  return request({
    url: '/system/consultant-supervisor',
    method: 'put',
    data: data
  })
}

// 删除咨询师-督导关系管理
export function delConsultant-supervisor(id) {
  return request({
    url: '/system/consultant-supervisor/' + id,
    method: 'delete'
  })
}
