app.controller('formInsert',function($scope,restService){



    $scope.cleanFields = function(){
        $scope.nim = "";
        $scope.nama = "";
        $scope.gender = "";
    }

    function testPromise(){
        var janji = new Promise(function (resolve,reject){
           if(true){
             resolve('Data OK');
           }
           reject('Data Error');
        });

        janji.then(function (ok){
            console.log(ok);
        },function (e){
            console.log(e);
        });
    }

    $scope.insertData = function (){
        var modelNim = $scope.nim;
        var modelNama =$scope.nama;
        var modelGender = $scope.gender;

        if(modelGender === '' || modelGender === undefined){
            alert('Radiobutton belum diisi');
        }else{
            restService.saveData(modelNim,modelNama,modelGender);
            $scope.cleanFields();
        }
    }
});