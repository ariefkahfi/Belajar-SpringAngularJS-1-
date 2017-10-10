app.controller('listData',function($scope,restService){

    $scope.formUpdate = false;

    $scope.loadData = function (){
        restService.loadData().then(function(success){
            $scope.data = success;
            console.log(success);
        },function (error){
            console.log(error);
        });
    };

    $scope.loadData();

    $scope.deleteData  = function (modelNim){
        restService.deleteData(modelNim).then((s)=>{
            $scope.loadData();
        },(e)=>{
            console.log(e);
        });
    }

    $scope.tampilForm = function (mhs){

        if($scope.formUpdate === false){
           $scope.formUpdate = true;

            $scope.updateNim = mhs.nim;
            $scope.updateNama = mhs.nama;
            $scope.updateGender = mhs.gender;
        }else{
           $scope.formUpdate = false;
        }
    }

    $scope.cleanAttr = function(){
        $scope.formUpdate = false;
        $scope.updateNim = "";
        $scope.updateNama = "";
        $scope.updateGender = "";
    }

    $scope.submitUpdate = function(){
      if($scope.updateNim === '' || $scope.updateNim === undefined ||
      $scope.updateNama ==='' || $scope.updateNama === undefined || $scope.updateGender === ''
      || $scope.updateGender === undefined){
            alert('Masih ada form yang kosong');
      }else{
        restService.updateData($scope.updateNim,$scope.updateNama,$scope.updateGender).then(
            (s)=>{
               console.log(s);
               $scope.loadData();
               $scope.cleanAttr();
            },(e)=>{
                console.log(e);
            }
        );
      }
    }
});