$('#change').click(function(){
    $('#input1').attr({'readOnly':false}); 
    $('#input2').attr({'readOnly':false}); 
    $('#input3').attr({'readOnly':false}); 
    
})
$('#confirm').click(function(){
    $('#input1').attr({'readOnly':true}); 
    $('#input2').attr({'readOnly':true}); 
    $('#input3').attr({'readOnly':true}); 
})
