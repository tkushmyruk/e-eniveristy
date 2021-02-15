<#import "common/common.ftlh" as com>
<@com.main>
    <br/>
    <br/>
    <h2>List of Faculties</h2>
   <div>
       <#list faculties as faculty>
           <div>${faculty.facultyName}</div>
           <div><a href="/faculty/${faculty.facultyName}"</div>
           <a href="/student-order/${faculty.facultyName}">Choose this faculty</a>
       </#list>
   </div>
    <div>
        <a href="/faculties/redaction">Redact Faculties</a>
    </div>
</@com.main>