import * as React from 'react';
import { connect } from 'dva';
// import styles from './IndexPage.css';
import { listStyle } from '../services/style';

class IndexPage extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      styles:[]
    };
  }

  componentDidMount(){
    listStyle().then(json => {
      console.log(json);
      this.setState({styles:json.data});
    })
  }

  render(){
    return (<div>
        {this.state.styles.map(item => 
          (<div>{item.name}</div>))}
      </div>);
  }
}



IndexPage.propTypes = {
};

export default connect()(IndexPage);
