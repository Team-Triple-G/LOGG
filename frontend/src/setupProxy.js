const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function(app) {
    app.use(
        "/api",
        createProxyMiddleware({
            target: "http://localhost:8080/api/v1/user/login",
            changeOrigin: true 
            //changeOrigin 설정은 http-proxy 모듈의 설명과 같이 대상 서버 구성에 따라 호스트 헤더가 변경되도록 설정
        })
    )
}
