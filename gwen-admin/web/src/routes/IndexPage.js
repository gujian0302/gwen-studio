import * as React from 'react';
import { connect } from 'dva';
// import styles from './IndexPage.css';
import Style from '../components/Style';
import AddStyle from '../components/AddStyle';
import { listStyle } from '../services/style';
import { Layout, Menu, Breadcrumb, Icon } from 'antd';

const { Header, Content, Footer, Sider } = Layout;
const SubMenu = Menu.SubMenu;

class IndexPage extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      collapsed:false,
      styles:[]
    };
  }

  onCollapse = (collapsed)=>{
    this.setState({collapsed});
  }

  componentDidMount(){
    listStyle().then(json => {
      console.log(json);
      this.setState({styles:json.data});
    })
  }

  render(){

    return (
      <Layout style={{ minHeight: '100vh'}}>
        <Sider
          collapsible
          collapsed={this.state.collapsed}
          onCollapse={this.onCollapse}
        >
        <Menu theme="dark" mode="inline">
          <Menu.Item key="1">
            <Icon type="pie-chart" />
            <span>风格</span>
          </Menu.Item>
        </Menu>
        </Sider>
        <Layout>
          <Header style={{background: '#fff', padding:0}} />
          <Content style={{margin: '0 16px'}}>
            <Style />
          </Content>
          <Footer style={{ textAlign: 'center'}}>
          </Footer>
        </Layout>
      </Layout>
      );
  }
}



IndexPage.propTypes = {
};

export default connect()(IndexPage);
