const base = {
    get() {
        return {
            url : "http://localhost:8080/yiqinggeliguanli/",
            name: "yiqinggeliguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yiqinggeliguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "疫情隔离管理系统"
        } 
    }
}
export default base
