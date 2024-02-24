# Apply Gaussian blur to a texture
func gaussian_blur(texture: ImageTexture, radius: int):
    # Create a temporary ImageTexture to hold the blurred image
    var temp_texture = ImageTexture.new()
    var image = texture.get_data()
    
    # Apply blur kernel to each pixel in the image
    for x in range(image.get_width()):
        for y in range(image.get_height()):
            var total = Color(0, 0, 0, 0)
