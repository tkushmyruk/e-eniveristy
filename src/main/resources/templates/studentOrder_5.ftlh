<#import "common/common.ftlh" as com>
<@com.main>
    <h2>${facultyName}</h2>
    <div>Add Certification Information</div>
    <form method="post">
    <div><label>First Name : <input type="text" name="firstName"></label></div>
    <div><label>Middle Name : <input type="text" name="middleName"></label></div>
    <div><label>Last Name : <input type="text" name="lastName"></label></div>
    <#list disciplines as discipline>
        <div><label>${discipline} : <input type="number" max="200" name="${discipline.disciplineName}"></label></div>
    </#list>
        <button type="submit">Save</button>
    </form>
</@com.main>