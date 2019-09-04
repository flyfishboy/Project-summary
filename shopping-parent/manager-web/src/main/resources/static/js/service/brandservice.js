app.service("brandservice",function($http) {
    this.findAll=function () {
        return $http.get("../brand/findAll");
    };
    this.findPage = function (page,row) {
        return $http.get("/brand/findPage?page="+page+"&row="+row);
    };
    this.findPageByCondition = function (page,row,entity) {
        return $http.post("/brand/findPageByEntity?page="+page+"&row="+row,entity);
    };
    this.update = function (entity) {
        return $http.post("/brand/update",entity);
    };
    this.add = function (entity) {
        return $http.post("/brand/add",entity);
    };
    this.findOne = function (id) {
        return $http.get("/brand/findOne?id="+id);
    };
    this.deleteOne = function (id) {
       return $http.get("/brand/deleteOne?id="+id);
    };
    this.deleteMany = function (ids) {
       return $http.get("/brand/deleteMany?ids="+ids);
    };

});