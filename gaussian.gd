# Apply Gaussian blur to a texture
func gaussian_blur(texture: ImageTexture, radius: int):
    # Create a temporary ImageTexture to hold the blurred image
    var temp_texture = ImageTexture.new()
    var image = texture.get_data()
    
    # Apply blur kernel to each pixel in the image
    for x in range(image.get_width()):
        for y in range(image.get_height()):
            var total = Color(0, 0, 0, 0)
            var count = 0
            
            # Apply Gaussian blur kernel to surrounding pixels
            for dx in range(-radius, radius + 1):
                for dy in range(-radius, radius + 1):
                    var nx = x + dx
                    var ny = y + dy
                    
                    if nx >= 0 and nx < image.get_width() and ny >= 0 and ny < image.get_height():
                        var pixel = image.get_pixel(nx, ny)
                        var weight = gaussian_kernel(dx, dy, radius)
                        total += pixel * weight
                        count += 1
            
            # Set the blurred pixel value
            image.set_pixel(x, y, total / count)
    
    # Update the ImageTexture with the blurred image
    temp_texture.create_from_image(image)
    return temp_texture

# Gaussian blur kernel function
func gaussian_kernel(x: int, y: int, radius: int) -> float:
    var sigma = radius / 3.0
    return exp(-(x * x + y * y) / (2 * sigma * sigma)) / (2 * PI * sigma * sigma)
