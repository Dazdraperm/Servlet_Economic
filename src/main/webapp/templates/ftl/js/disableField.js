function input ()
{

    $('fieldset.disable_field').keyup(function () {
        // alert(this.value());

        $('fieldset.disable_field').not(this).prop('disabled', true);
        // $('li.asa').not(this).attr('hidden', true);

    });


}