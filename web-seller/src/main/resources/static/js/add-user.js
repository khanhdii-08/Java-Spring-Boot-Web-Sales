const f = document.querySelector('#imageFile');

f.onchange = function (evt) {
    var tgt = evt.target || window.event.srcElement,
        files = tgt.files;

    // FileReader support
    if (FileReader && files && files.length) {
        var fr = new FileReader();

        fr.onload = function () {
            document.getElementById("image").src = fr.result;
        }
        fr.readAsDataURL(files[0]);
    }
}



var txtFirstName = document.querySelector('#txtFirstName');
var txtLastName = document.querySelector('#txtLastName');
var txtMail = document.querySelector('#txtEmail');
var formCheck = document.querySelector('#formAdd');
var txtPass = document.querySelector('#txtPass');
var txtRePass = document.querySelector('#txtRePass');

formCheck.addEventListener('submit', function checkValidFormAdd(e){
    var regexFirstName =/([A-Z][a-z]{0,})+$/;
    var regexLastName = /([A-Z][a-z]{0,})+$/;
    var regexEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
    var erroFirstName = document.querySelector('#errorFirstName');
    var erroLastName = document.querySelector('#errorLastName');
    var erroMail = document.querySelector('#errorEmail');
    var errorPass = document.querySelector('#errorPass');
    var errorRePass = document.querySelector('#errorRePass');
    if(txtFirstName.value==""){
        e.preventDefault();
        erroFirstName.innerText = "Vui lòng không để trống Họ";
        return false;
    }
    
    if(txtLastName.value==""){
        e.preventDefault();
        erroLastName.innerText = "Vui lòng không để trống Tên";
        return false;
    }
    
    if(txtMail.value==""){
        e.preventDefault();
        erroMail.innerText = "Vui lòng không để trống Email";
        return false;
    }
   
    if(!regexEmail.test(txtMail.value)){
        e.preventDefault();
        erroMail.innerText = "Vui lòng nhập đúng định dạng email";
        return false;
    }
   

    if (!regexFirstName.test(txtFirstName.value)) {
        e.preventDefault();
        erroFirstName.innerText = "Chữ cái đầu tiên phải viết Hoa";
        return false;
      }
      
     
     
    if (!regexLastName.test(txtLastName.value)) {
        e.preventDefault();
        erroLastName.innerText = "Chữ cái đầu tiên phải viết Hoa";
        return false;
      }
    if(txtPass.value ==""){
        e.preventDefault();
        errorPass.innerText = "Không được để trống mật khẩu";
        return false;
    }
    if(txtPass.value.length <6){
        e.preventDefault();
        errorPass.innerText = "mật khẩu tối thiểu 6 ký tự";
        return false;
    }
    if(txtPass.value ==""){
        e.preventDefault();
        errorPass.innerText = "Không được để trống";
        return false;
    }
    if(txtPass.value !== txtRePass.value){
        e.preventDefault();
        errorRePass.innerText = "Mật khẩu chưa khớp";
        return false;
    }
    
    else{
        errorPass.innerText = "";
        errorRePass.innerText = "";
        erroFirstName.innerText = "";
        erroLastName.innerText = "";
        erroMail.innerText = "";
        return true;
    }
   
    // erroLastName.innerText = "";
    
   
    // return true;
});