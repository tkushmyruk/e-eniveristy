<#import "common/common.ftlh" as com>
<@com.main>
    <h2>${facultyName}</h2>
    <div>Add photo of your school certificate and passport</div>
    <form method="post" enctype="multipart/form-data">
        <div>
            <p>Passport Photo</p>
            <input type="file" name="passportPhotofile" id="passport">
        </div>
        <div>
            <p>Certificate Photo</p>
            <input type="file" name="certificatePhotofile" id="certificate">
        </div>
        <button type="submit">Save</button>
    </form>
</@com.main>