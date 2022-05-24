$.validator.addMethod("idCk",  function( value, element ) {
	return this.optional(element) ||  /^[a-z0-9_-]{5,20}$/.test(value);
});
 
$.validator.addMethod("passwordCk",  function( value, element ) {
	return this.optional(element) ||  /^.*(?=^.{8,16}$)(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_-]).*$/.test(value);
});
 
$.validator.addMethod("birthdayCk",  function( value, element ) {
	return this.optional(element) ||  /^[0-9]{8,8}$/.test(value);
}); 

$.validator.addMethod("nameCk",  function( value, element ) {
	return this.optional(element) ||  /^[가-힣]{2,4}$/.test(value);
}); 

$.validator.addMethod("certiNum",  function( value, element ) {
return this.optional(element) ||  /^.*(?=^.{8,8}$)(?=.*[a-zA-Z0-9+]).*$/.test(value);
});

$.validator.addMethod("tellCK",  function( value, element ) {
return this.optional(element) ||  /^.*(?=^.{3,4}$)(?=.*[0-9+]).*$/.test(value);
});

$.validator.addMethod("tell2CK",  function( value, element ) {
return this.optional(element) ||  /^.*(?=^.{4,4}$)(?=.*[0-9+]).*$/.test(value);
});