app.controller("brandController",function($scope,$controller,brandservice){
    $controller('basecontroller',{$scope:$scope});
    $scope.findAll = function () {
        brandservice.findAll().success(function (data) {
            $scope.brandList = data;
        })
    };
    $scope.findPage = function (page,row) {
        brandservice.findPage(page,row).success(function (data) {
            $scope.brandList = data.rows;
            $scope.paginationConf.totalItems = data.total;
        })
    };
    $scope.findPageByCondition = function(){
        brandservice.findPageByCondition($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage,$scope.entityCondition)
            .success(function (data) {
            $scope.brandList = data.rows;
            $scope.paginationConf.totalItems = data.total;
            })
    };


    $scope.save = function () {
        var servicesave = null;
        if ($scope.brand.id != null) {
            servicesave = brandservice.update;

        }else {
            servicesave = brandservice.add;
        }
        servicesave($scope.brand)
            .success(function (data) {
                if (data.success) {
                    $scope.reload();
                    $scope.ids = [];
                    $scope.brand = {};
                } else {
                    alert("失败原因：" + data.message);
                }
            });
    };

    $scope.findOne = function (id) {
        brandservice.findOne(id)
            .success(function (data) {
                if (data.id > 0) {
                    $scope.brand = {id: data.id, name: data.name, firstChar: data.firstChar};
                } else {
                    alert("Id:" + id + "不存在");
                }
            });
    };

    $scope.deleteOne = function (id) {
        brandservice.deleteOne(id)
            .success(function (data) {
                if (data.success) {
                    $scope.reload();
                } else {
                    alert("失败原因：" + data.message);
                }
            })
    };


    $scope.deleteMany=function () {
      brandservice.deleteMany($scope.ids)
            .success(function (data) {
                if (data.success) {
                    $scope.ids = [];
                    $scope.reload();
                } else {
                    $scope.ids = [];
                    alert("失败原因：" + data.message);
                }
            })
    }

});