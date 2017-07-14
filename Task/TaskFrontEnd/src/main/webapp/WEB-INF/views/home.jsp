<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Register</h2>

		<form class="form-horizontal" action="register" method="post"
			enctype="multipart/form-data">
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name"
						placeholder="Enter Name" name="name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email"
						placeholder="Enter email" name="email">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password"
						placeholder="Enter password" name="password">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="gender">Gender:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="gender"
						placeholder="M/F" name="gender">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">Nationality:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="nationality"
						placeholder="Enter Nationality" name="nationality">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Mobile:</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="mble"
						placeholder="Enter Number" name="mobile">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Address:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="address"
						placeholder="Enter Adress" name="address">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">District:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="dist"
						placeholder="Enter District" name="district">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="zip">Zip:</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="zipcode"
						placeholder="Enter Zip" name="zipCode">
				</div>
			</div>

			<td>File to upload:</td>
			<tr>
				<td>File Upload:</td>
				<td><input type="file" name="fileUpload" /></td>
			</tr>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>
