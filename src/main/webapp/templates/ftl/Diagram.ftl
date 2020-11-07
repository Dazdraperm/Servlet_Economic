<#include "Base.ftl">
<#macro head>

    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@700&family=Raleway:ital,wght@0,400;0,600;1,700&display=swap"
          rel="stylesheet">


    <link rel="stylesheet" href="templates/ftl/css/diagram.css">
</#macro>

<#macro content>
    <div id="piechart_3d" style="margin-top: 100px; margin-left: 775px; width: 400px; height: 350px;"></div>

    <div class="container">
        <div class="row px-15">
            <div class="col-lg-3 col-xl-7 card flex-row mx-auto px-0">
                <div class="card-body">

                    <script src="templates/ftl/js/Show_Add_Category.js"></script>
                    <button onclick="show()" id="delete_but" class="title text-center mt-2">Create your category</button>
                    <br>
                    <button onclick="showChange()" id="delete_but_change" class="title text-center mt-2">Add your income and expenses</button>
                    <br>

                    <form class="form-box px-1" id="show" method="post" action="/diagram">

                    </form>




                    <form class="form-box px-3" name="search_form" id="showChange" style="margin-top: 75px;" method="post" action="/diagramChange" >

                    </form>


                    <script src="templates/ftl/js/AjaxSearch_Category.js"></script>
                    <script src="templates/ftl/js/AjaxRemove.js"></script>




                        <#if listCategory??>

                            <#list listCategory as category >
                                <fieldset onclick="input()" class="disable_field">
                                    <div class="form-input">
                                        <input type="login" hidden oninput="inputChange(name, value)"  class="disable_field_name" name=${category.getCategory()} value=${category.getCategory()} placeholder="name" tabindex="10" required>


                                        <input type="login" hidden oninput="inputChangeCount(value, id)" class="disable_field_count" name=${category.getCategory()} value=${category.getCountCategory()} placeholder="count" tabindex="10" required id=${category.getCountCategory()}>
                                    </div>

                                    <input type="hidden" name="name" value=${category.getCategory()}>
                                </fieldset>

                            </#list >

                        </#if>

                </div>
            </div>
        </div>
    </div>






</#macro>