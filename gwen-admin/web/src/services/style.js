import request from '../utils/request';

export function listStyle(){
	return request(`${require('../utils/host')}/style/list-all`);
}