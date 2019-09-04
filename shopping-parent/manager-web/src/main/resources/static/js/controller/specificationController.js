 //控制层 
app.controller('specificationController' ,function($scope,$controller ,specificationService){
	
	$controller('basecontroller',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		specificationService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		specificationService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	};

	$scope.findPageByCondition = function(){
		specificationService.findPageByCondition($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage,$scope.entityCondition)
			.success(function (data) {
				$scope.list = data.rows;
				$scope.paginationConf.totalItems = data.total;
			})
	};
	
	//查询实体 
	$scope.findOne=function(id){				
		specificationService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	};
	
	//保存 
	$scope.save=function(){				
		var serviceObject = null;//服务层对象
		if($scope.entity.id!=null){//如果有ID
			serviceObject=specificationService.update; //修改
		}else{
			serviceObject=specificationService.add;//增加
		}				
		serviceObject($scope.entity)
			.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reload();//重新加载
					$scope.ids = [];
					$scope.entity = {};
				}else{
					alert("失败原因："+response.message);
				}
			}		
		);				
	};

	$scope.deleteOne = function (id) {
		specificationService.deleteOne(id)
			.success(function (data) {
				if (data.success) {
					$scope.reload();
				} else {
					alert("失败原因：" + data.message);
				}
			})
	};
	 
	//批量删除
	$scope.deleteMany=function () {
		specificationService.deleteMany($scope.ids)
			.success(function (data) {
				if (data.success) {
					$scope.ids = [];
					$scope.reload();
				} else {
					$scope.ids = [];
					alert("失败原因：" + data.message);
				}
			})
	};
	
	//$scope.searchEntity={};//定义搜索对象

});	
