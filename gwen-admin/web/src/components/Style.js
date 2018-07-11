import * as React from 'react';

import { Button, Modal, Icon } from 'antd';

import AddStyle from './AddStyle';
import styles from './style.less';

import { listStyle, deleteStyle } from '../services/style'; 


class Style extends React.Component {
	constructor(props){
		super(props);
		this.state = {
			list:[],
			addStyle:{
				visible: false
			}
		}
	}

	showAddStyle = () => {
		this.setState({addStyle:{...this.state.addStyle, visible:true}})
	}

	closeAddStyle = () => {
		this.setState({addStyle:{...this.state.addStyle, visible:false}});
	}

	onSuccess = () => {
		listStyle().then(data => this.setState({list:data.data,addStyle:{...this.state.addStyle, visible:false}}));
	}

	onDelete = (id) => {
		deleteStyle(id).then(this.refresh);
	}
  
  refresh=()=>{
		listStyle().then(data => this.setState({list:data.data}))
  }

	componentDidMount(){
		this.refresh();
	}

	render(){
		return (
			<div className={styles.container}>
		    <Button className={styles.btn} onClick={this.showAddStyle}>添加</Button>
		    <Modal 
		      visible={this.state.addStyle.visible}
		      footer={null}
		      onCancel={this.closeAddStyle}
		    >
		      <AddStyle success={this.onSuccess} />
		    </Modal>

		    <div className={styles.list}>
		      {
		      	this.state.list.map(item => 
		      	  (
		      	    <div key={item.id} className={styles.item}>
		      	      <Icon type="close" className={styles.icon} onClick={()=>this.onDelete(item.id)} />
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