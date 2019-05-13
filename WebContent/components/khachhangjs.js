

/*$('.submit').click(function(){
   validateForm();   
});*/
$('.input-in4').blur(function(){
   validateForm();   
});

function validateForm(){
    var isValid = true;
    var nameReg = /./;
    var numberReg =  /^(090|091|\(84\)\+90|\(84\)\+91)\d{7}$/;
    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
    var maReg = /^(KH)\d{5}$/;

    var makhs = $('#inputMaKH').val();
    var names = $('#inputTenKH').val();
    var email = $('#emailKH').val();
    var telephone = $('#sdtKH').val();
    var add = $('#diachiKH').val();
  
    var inputVal = new Array(makhs, names, add, email, telephone);

    var inputMessage = new Array("Mã K.Hang", "Tên K.Hang", "Địa chỉ" ,"Email", "Số điện thoại");

     $('.error').hide();
        if(inputVal[0] == ""){
            $('#inputMaKH').after('<span class="error"> Vui lòng nhập trường ' + inputMessage[0] + '</span>');
            isValid = false;
        } 
        else if(!maReg.test(makhs)){
            $('#inputMaKH').after('<span class="error"> Nhập sai định dạng</span>');
            isValid = false;
        }

        if(inputVal[1] == ""){
            $('#inputTenKH').after('<span class="error"> Vui lòng nhập trường ' + inputMessage[1] + '</span>');
            isValid = false;
        } else if (!nameReg.test(names)){
            $('#inputTenKH').after('<span class="error"> Tên chỉ được chứa kí tự thường</span>');
            isValid = false;
        }

        if(inputVal[2] == ""){
            $('#diachiKH').after('<span class="error"> Vui lòng nhập trường ' + inputMessage[2] + '</span>');
            isValid = false;
        }

        if(inputVal[3] == ""){
            $('#emailKH').after('<span class="error"> Vui lòng nhập trường ' + inputMessage[3] + '</span>');
            isValid = false;
        } 
        else if(!emailReg.test(email)){
            $('#emailKH').after('<span class="error"> Email sai định dạng</span>');
            isValid = false;
        }

        if(inputVal[4] == ""){
            $('#sdtKH').after('<span class="error"> Vui lòng nhập trường ' + inputMessage[4] + '</span>');
            isValid = false;
        } 
        else if(!numberReg.test(telephone)){
            $('#sdtKH').after('<span class="error"> SDT sai định dạng</span>');
            isValid = false;
        }  

        return isValid;    
}   
