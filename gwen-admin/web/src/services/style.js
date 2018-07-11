import request from '../utils/request';

const host = require('../utils/host');

export function listStyle(){
	return request(`${host}/style/list-all`);
}

export function saveStyle(style){
	return request(`${host}/style/save`,
		{
			method: 'post',
			body: JSON.stringify(style),
			headers: {
				"Content-Type": "application/json;charset=utf-8"
			}
		})
}

export function deleteStyle(id){
	return request(`${host}/style/delete?id=${id}`, {method: 'DELETE'});
}