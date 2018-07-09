
if (process.env.NODE_ENV === 'production') {
    module.exports = `https://www.baidu.com`
}else{
  module.exports = 'http://localhost:8000'
 } 
// }else {
//     module.exports = `http://192.168.0.109:8080`
// }
