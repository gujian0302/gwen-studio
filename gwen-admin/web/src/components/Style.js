import * as React from 'react';

import { Button } from 'antd';
import styles from './style.less';

import { listStyle } from '../services/style'; 


class Style extends React.Component {
	constructor(props){
		super(props);
		this.state = {
			list:[]
		}
	}

	componentDidMount(){
		listStyle().then(data => this.setState({list:data.data}))
	}

	render(){
		return (
			<div className={styles.container}>
		    <Button className={styles.btn}>添加</Button>

		    <div className={styles.list}>
		      {
		      	this.state.list.map(item => 
		      	  (
		      	    <div className={styles.item}>
		      	      {item.name}
		      	     </div>)
		      	   )
		      }
		    </div>
			</div>
			 );
	}

}

export default Style;